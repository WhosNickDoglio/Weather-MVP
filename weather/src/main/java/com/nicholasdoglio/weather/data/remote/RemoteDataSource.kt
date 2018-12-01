package com.nicholasdoglio.weather.data.remote

import com.nicholasdoglio.weather.BuildConfig
import com.nicholasdoglio.weather.data.mapper.CurrentWeatherMapper
import com.nicholasdoglio.weather.data.mapper.ForecastMapper
import com.nicholasdoglio.weather.data.model.CurrentWeather
import com.nicholasdoglio.weather.data.model.Forecast
import io.reactivex.Single
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val weatherService: WeatherService,
    private val currentWeatherMapper: CurrentWeatherMapper,
    private val forecastMapper: ForecastMapper
) {

    private val weatherApiKey = BuildConfig.WEATHER_API_KEY
    private val imperialUnits = "imperial"
    private val metricUnits = "metric"

    fun getWeather(lat: Double, long: Double): Single<CurrentWeather> =
        weatherService.getWeather(
            lat,
            long,
            weatherApiKey,
            imperialUnits
        )
            .map(currentWeatherMapper::mapFromResponse)

    fun getUpdatesForList(listOfCityIds: String): Single<List<CurrentWeather>> {
        return weatherService.getSavedCitiesCurrentWeather(
            listOfCityIds,
            weatherApiKey,
            imperialUnits
        )
            .map { listOfCitiesResponse ->
                val updatedList = mutableListOf<CurrentWeather>()
                listOfCitiesResponse.list
                    .forEach { updatedList.add(currentWeatherMapper.mapFromResponse(it)) }
                updatedList
            }
    }

    fun getForecast(id: String): Single<Forecast> =
        weatherService.getForecast(id, weatherApiKey, imperialUnits)
            .map { forecastMapper.mapFromResponse(it) }
}