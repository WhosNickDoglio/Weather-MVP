package com.nicholasdoglio.persistence

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CurrentWeather::class, Forecast::class], version = 1, exportSchema = true)
abstract class WeatherDatabase : RoomDatabase() {
  abstract fun currentWeatherDao(): CurrentWeatherDao
  abstract fun forecastDao(): ForecastDao
}