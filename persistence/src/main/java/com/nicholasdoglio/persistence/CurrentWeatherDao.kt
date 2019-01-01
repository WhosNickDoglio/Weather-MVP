package com.nicholasdoglio.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
abstract class CurrentWeatherDao {

  @Insert
  abstract fun addLocation(currentWeather: CurrentWeather): Completable

  @Insert
  abstract fun addListOfLocations(weatherList: List<CurrentWeather>): Completable

  @Delete
  abstract fun removeLocation(currentWeather: CurrentWeather): Completable

  @Query("DELETE FROM CurrentWeather")
  abstract fun clearTable(): Completable

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