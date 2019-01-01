package com.nicholasdoglio.remote

import io.reactivex.Single
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
  private val weatherService: WeatherService
//  private val currentWeatherMapper: CurrentWeatherMapper,
//  private val forecastMapper: ForecastMapper
) {

  private val weatherApiKey = "" //BuildConfig.WEATHER_API_KEY
  private val imperialUnits = "imperial"
  private val metricUnits = "metric"

  fun getWeather(lat: Double, long: Double): Single<CurrentWeather> =
    weatherService.getWeather(lat, long, weatherApiKey, imperialUnits).map { CurrentWeather() }

  fun getUpdatesForList(listOfCityIds: String): Single<List<CurrentWeather>> {
    return weatherService.getSavedCitiesCurrentWeather(
      listOfCityIds,
      weatherApiKey,
      imperialUnits
    )
      .map { listOfCitiesResponse ->
        val updatedList = mutableListOf<CurrentWeather>()
        listOfCitiesResponse.list
//          .forEach { updatedList.add(currentWeatherMapper.mapFromResponse(it)) }
        updatedList
      }
  }

  fun getForecast(id: String): Single<Forecast> =
    weatherService.getForecast(id, weatherApiKey, imperialUnits).map { Forecast() }
//      .map { forecastMapper.mapFromResponse(it) }
}


