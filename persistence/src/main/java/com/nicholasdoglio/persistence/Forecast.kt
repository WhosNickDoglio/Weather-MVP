package com.nicholasdoglio.persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Forecast(
  @PrimaryKey val id: Int,
  val locationName: String
)