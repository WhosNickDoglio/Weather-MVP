package com.nicholasdoglio.weather.data.repo

import com.nicholasdoglio.weather.data.entities.CurrentWeather
import com.nicholasdoglio.weather.data.entities.Forecast
import com.nicholasdoglio.weather.data.local.WeatherDatabase
import com.nicholasdoglio.weather.data.mapper.CurrentWeatherMapper
import com.nicholasdoglio.weather.data.mapper.ForecastMapper
import com.nicholasdoglio.weather.data.remote.WeatherService
import com.nicholasdoglio.weather.util.Constants
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Nicholas Doglio
 */
@Singleton
class WeatherRepository @Inject constructor(
    private val weatherService: WeatherService,
    private val currentWeatherMapper: CurrentWeatherMapper,
    private val forecastMapper: ForecastMapper,
    private val weatherDatabase: WeatherDatabase
) :
    Repository {
    //TODO Shared Preferences for units

    //TODO caching
    private val savedLocationList = mutableListOf<CurrentWeather>()

    override fun addLocation(currentWeather: CurrentWeather): Boolean =
        when (savedLocationList.size <= 10 && !savedLocationList.contains(currentWeather)) {
            true -> {
                Timber.d("Location added: %s", currentWeather.locationName)
                savedLocationList.add(currentWeather); true
            }
            false -> false
        }

    override fun removeLocation(id: Int) {
        val currentWeather = savedLocationList
            .find { it.id == id }

        savedLocationList.remove(currentWeather)
        Timber.d("%s removed", currentWeather?.locationName)
    }

    override fun getWeather(lat: Double, long: Double): Single<CurrentWeather> =
        weatherService.getWeather(lat, long, Constants.WEATHER_API_KEY, Constants.IMPERIAL_UNITS)
            .doOnSubscribe { Timber.d(" New current weather request made") }
            .map { weatherResponse -> currentWeatherMapper.mapFromResponse(weatherResponse) }

    //TODO This needs a lot of work
    override fun updateWeatherList(): Completable {
        val idList = mutableListOf<Int>()

        savedLocationList
            .forEach { idList.add(it.id) }

        val combinedIds = idList.joinToString(",")
        Timber.d("All IDs: %s", combinedIds)

        savedLocationList.clear()
        return Completable.fromSingle(
            weatherService.getSavedCitiesCurrentWeather(
                combinedIds,
                Constants.WEATHER_API_KEY,
                Constants.IMPERIAL_UNITS
            )
                .doOnSubscribe { Timber.d("Weather list refreshed") }
                .map { listOfCitiesResponse ->
                    listOfCitiesResponse.list
                        .forEach { addLocation(currentWeatherMapper.mapFromResponse(it)) }
                }
        )
    }

    //TODO this doesn't work as intended
    override fun getWeatherList(): Flowable<List<CurrentWeather>> =
        Flowable.just(savedLocationList)

    override fun getForecast(id: String): Single<Forecast> =
        weatherService.getForecast(id, Constants.WEATHER_API_KEY, Constants.IMPERIAL_UNITS)
            .doOnSubscribe { Timber.d("Forecast request made") }
            .map { response -> forecastMapper.mapFromResponse(response) }
}