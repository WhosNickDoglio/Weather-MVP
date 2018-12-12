package com.nicholasdoglio.weather.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Forecast(
  @PrimaryKey val id: Int,
  val locationName: String
)