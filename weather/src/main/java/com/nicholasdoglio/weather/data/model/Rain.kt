package com.nicholasdoglio.weather.data.model

import com.squareup.moshi.Json

data class Rain(
    @Json(name = "3h") val h: Double
)