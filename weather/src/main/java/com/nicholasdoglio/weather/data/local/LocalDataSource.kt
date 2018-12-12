package com.nicholasdoglio.weather.data.local

import com.nicholasdoglio.weather.data.model.CurrentWeather
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val weatherDatabase: WeatherDatabase) {

  fun getCurrentWeatherList() = weatherDatabase.currentWeatherDao().getWeatherList()

  fun getCityIds(): Single<String> =
    weatherDatabase.currentWeatherDao().getAllIds().map { listOfIds -> listOfIds.joinToString(",") }

  //Instead of blocking the add in the repo, block FAB in listFragment by observing this
  fun getNumberOfCitiesInList() = weatherDatabase.currentWeatherDao().getNumberOfCities()

  fun addCityToList(currentWeather: CurrentWeather): Completable =
    Completable.fromAction { weatherDatabase.currentWeatherDao().addLocation(currentWeather) }

  fun addListOFCitiesToList(currentWeather: List<CurrentWeather>): Completable =
    Completable.fromAction {
      weatherDatabase.currentWeatherDao().addListOfLocations(currentWeather)
    }

  fun removeCity(currentWeather: CurrentWeather): Completable = Completable.fromAction {
    weatherDatabase.currentWeatherDao().removeLocation(currentWeather)
  }

  fun getCityById(id: Int) = weatherDatabase.currentWeatherDao().getLocation(id)

  fun clearList(): Completable =
    Completable.fromAction { weatherDatabase.currentWeatherDao().clearTable() }
}
