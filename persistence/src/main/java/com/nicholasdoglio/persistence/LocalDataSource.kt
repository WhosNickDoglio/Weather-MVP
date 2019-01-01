package com.nicholasdoglio.persistence

import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val currentWeatherDao: CurrentWeatherDao) {

  fun getCurrentWeatherList() = currentWeatherDao.getWeatherList()

  fun getCityIds(): Single<String> =
    currentWeatherDao.getAllIds().map { listOfIds -> listOfIds.joinToString(",") }

  //Instead of blocking the add in the repo, block FAB in listFragment by observing this
  fun getNumberOfCitiesInList() = currentWeatherDao.getNumberOfCities()

  fun addCityToList(currentWeather: CurrentWeather): Completable =
    Completable.fromAction { currentWeatherDao.addLocation(currentWeather) }

  fun addListOFCitiesToList(currentWeather: List<CurrentWeather>): Completable =
    currentWeatherDao.addListOfLocations(currentWeather)

  fun removeCity(currentWeather: CurrentWeather): Completable =
    currentWeatherDao.removeLocation(currentWeather)

  fun getCityById(id: Int) = currentWeatherDao.getLocation(id)

  fun clearList(): Completable = currentWeatherDao.clearTable()
}
