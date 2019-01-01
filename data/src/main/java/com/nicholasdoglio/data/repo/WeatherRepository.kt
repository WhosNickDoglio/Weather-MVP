/*
package com.nicholasdoglio.data.repo

import com.nicholasdoglio.data.model.CurrentWeather
import com.nicholasdoglio.data.model.Forecast
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(
//  private val remoteDataSource: RemoteDataSource,
//  private val localDataSource: LocalDataSource
) : Repository {
  override fun addLocation(lat: Double, long: Double): Completable {
    return remoteDataSource.getWeather(lat, long)
      .flatMapCompletable { localDataSource.addCityToList(it) }
  }

  override fun removeLocation(currentWeather: CurrentWeather): Completable {
    return localDataSource.removeCity(currentWeather)
  }

  override fun getWeather(id: Int): Single<CurrentWeather> {
    return localDataSource.getCityById(id)
  }

  //This doesn't work
  override fun updateWeatherList(): Completable = localDataSource.getCityIds()
    .flatMap { listOfIds -> remoteDataSource.getUpdatesForList(listOfIds) }
    .flatMapCompletable { localDataSource.addListOFCitiesToList(it) }

  override fun observeWeatherLocations(): Flowable<List<CurrentWeather>> {
    return localDataSource.getCurrentWeatherList()
  }

  override fun observeNumberOfLocations(): Flowable<Int> {
    return localDataSource.getNumberOfCitiesInList()
  }

  override fun getForecast(id: String): Single<Forecast> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    // SwitchIfEmpty
  }
}

//TODO label the time the weather/forecast is being pulled*/