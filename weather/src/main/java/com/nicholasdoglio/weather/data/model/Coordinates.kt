package com.nicholasdoglio.weather.data.model

import com.squareup.moshi.Json

data class Coordinates(
    @Json(name = "lon")
    val lon: Double,

    @Json(name = "lat")
    val lat: Double
)