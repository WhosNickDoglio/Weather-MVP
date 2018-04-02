package com.nicholasdoglio.weather.data.model

import com.squareup.moshi.Json

data class Wind(

    @Json(name = "deg")
    val deg: Double,

    @Json(name = "speed")
    val speed: Double
)