package com.nicholasdoglio.weather.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.nicholasdoglio.weather.data.model.CurrentWeather
import com.nicholasdoglio.weather.data.model.Forecast

@Database(entities = [CurrentWeather::class, Forecast::class], version = 1, exportSchema = true)
abstract class WeatherDatabase() : RoomDatabase() {
    abstract fun currentWeatherDao(): CurrentWeatherDao
    abstract fun forecastDao(): ForecastDao
}