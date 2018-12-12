package com.nicholasdoglio.weather.data.repo

import com.nicholasdoglio.weather.data.model.CurrentWeather
import com.nicholasdoglio.weather.data.model.Forecast
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * @author Nicholas Doglio
 */
interface Repository {

  fun addLocation(lat: Double, long: Double): Completable

  fun removeLocation(currentWeather: CurrentWeather): Completable

  fun getWeather(id: Int): Single<CurrentWeather>

  fun updateWeatherList(): Completable

  fun observeWeatherLocations(): Flowable<List<CurrentWeather>>

  fun observeNumberOfLocations(): Flowable<Int>

  fun getForecast(id: String): Single<Forecast>
}