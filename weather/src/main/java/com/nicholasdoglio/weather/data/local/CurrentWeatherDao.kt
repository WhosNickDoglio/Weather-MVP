package com.nicholasdoglio.weather.data.local

import android.arch.persistence.room.*
import com.nicholasdoglio.weather.data.model.CurrentWeather
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
abstract class CurrentWeatherDao {

    @Insert
    abstract fun addLocation(currentWeather: CurrentWeather)

    @Insert
    abstract fun addListOfLocations(weatherList: List<CurrentWeather>)

    @Delete
    abstract fun removeLocation(currentWeather: CurrentWeather)

    @Query("DELETE FROM CurrentWeather")
    abstract fun clearTable()

    @Query("SELECT * FROM CurrentWeather WHERE id = :id")
    abstract fun getLocation(id: Int): Single<CurrentWeather>

    @Query("SELECT * FROM CurrentWeather")
    abstract fun getWeatherList(): Flowable<List<CurrentWeather>>

    @Query("SELECT count(*) FROM CurrentWeather")
    abstract fun getNumberOfCities(): Flowable<Int>

    @Query("SELECT id FROM CurrentWeather")
    abstract fun getAllIds(): Single<List<Int>>

    @Transaction
    open fun updateWeatherList() {
        clearTable()

    }
}