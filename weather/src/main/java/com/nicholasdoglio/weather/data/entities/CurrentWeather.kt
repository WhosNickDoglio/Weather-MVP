package com.nicholasdoglio.weather.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class CurrentWeather(
    @PrimaryKey val id: Int,
    val locationName: String,
    val currentTemp: Double,
    val weatherImage: Int
)