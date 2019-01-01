package com.nicholasdoglio.persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CurrentWeather(
  @PrimaryKey val id: Int,
  val locationName: String,
  val currentTemp: Double,
  val weatherImage: Int
)