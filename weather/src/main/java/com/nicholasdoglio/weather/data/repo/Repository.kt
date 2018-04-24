package com.nicholasdoglio.weather.data.repo

import com.nicholasdoglio.weather.data.entities.CurrentWeather
import com.nicholasdoglio.weather.data.entities.Forecast
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

    fun getWeatherList(): Flowable<List<CurrentWeather>>

    fun getForecast(id: String): Single<Forecast>
}