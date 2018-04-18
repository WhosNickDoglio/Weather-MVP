package com.nicholasdoglio.weather.data.local

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.nicholasdoglio.weather.data.entities.CurrentWeather
import io.reactivex.Flowable
import io.reactivex.Single

interface CurrentWeatherDao {

    @Insert
    fun addLocation(currentWeather: CurrentWeather)

    @Insert
    fun addListOfLocations(weatherList: List<CurrentWeather>)

    @Delete
    fun removeLocation(currentWeather: CurrentWeather)

    @Query("DELETE FROM CurrentWeather")
    fun clearTable()

    @Query("SELECT * FROM CurrentWeather WHERE id = :id")
    fun getLocation(id: Int): Single<CurrentWeather>

    @Query("SELECT * FROM CurrentWeather")
    fun getWeatherList(): Flowable<CurrentWeather>

    @Query("SELECT count(*) FROM CurrentWeather")
    fun getNumberOfCities(): Single<Int>
}