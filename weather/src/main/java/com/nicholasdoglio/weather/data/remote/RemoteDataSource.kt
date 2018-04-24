package com.nicholasdoglio.weather.data.remote

import com.nicholasdoglio.weather.data.entities.CurrentWeather
import com.nicholasdoglio.weather.data.entities.Forecast
import com.nicholasdoglio.weather.data.mapper.CurrentWeatherMapper
import com.nicholasdoglio.weather.data.mapper.ForecastMapper
import com.nicholasdoglio.weather.util.Constants
import io.reactivex.Single
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val weatherService: WeatherService,
    private val currentWeatherMapper: CurrentWeatherMapper,
    private val forecastMapper: ForecastMapper
) {

    fun getWeather(lat: Double, long: Double): Single<CurrentWeather> =
        weatherService.getWeather(
            lat,
            long,
            Constants.WEATHER_API_KEY,
            Constants.IMPERIAL_UNITS
        )
            .map(currentWeatherMapper::mapFromResponse)

    fun getUpdatesForList(listOfCityIds: String): Single<List<CurrentWeather>> {
        return weatherService.getSavedCitiesCurrentWeather(
            listOfCityIds,
            Constants.WEATHER_API_KEY,
            Constants.IMPERIAL_UNITS
        )
            .map { listOfCitiesResponse ->
                val updatedList = mutableListOf<CurrentWeather>()
                listOfCitiesResponse.list
                    .forEach { updatedList.add(currentWeatherMapper.mapFromResponse(it)) }
                updatedList
            }
    }

    fun getForecast(id: String): Single<Forecast> =
        weatherService.getForecast(id, Constants.WEATHER_API_KEY, Constants.IMPERIAL_UNITS)
            .map(forecastMapper::mapFromResponse)
}