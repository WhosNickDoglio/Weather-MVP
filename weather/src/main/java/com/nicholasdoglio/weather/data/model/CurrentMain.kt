package com.nicholasdoglio.weather.data.model

import com.squareup.moshi.Json

data class CurrentMain(
    @Json(name = "temp")
    val temp: Double,

    @Json(name = "temp_min")
    val tempMin: Double,

    @Json(name = "humidity")
    val humidity: Int,

    @Json(name = "pressure")
    val pressure: Double,

    @Json(name = "temp_max")
    val tempMax: Double
)