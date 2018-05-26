package com.nicholasdoglio.weather.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Forecast(
    @PrimaryKey val id: Int,
    val locationName: String
)