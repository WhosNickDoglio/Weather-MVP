package com.nicholasdoglio.weather.data.model

import com.squareup.moshi.Json

data class CurrentSys(
    @Json(name = "country")
    val country: String,

    @Json(name = "sunrise")
    val sunrise: Int,

    @Json(name = "sunset")
    val sunset: Int,

    @Json(name = "id")
    val id: Int,

    @Json(name = "type")
    val type: Int,

    @Json(name = "message")
    val message: Double
)