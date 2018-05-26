package com.nicholasdoglio.weather.data.response

import com.squareup.moshi.Json

data class Main(
    @Json(name = "temp") val temp: Double,
    @Json(name = "pressure") val pressure: Double,
    @Json(name = "humidity") val humidity: Double,
    @field:Json(name = "temp_min") val tempMin: Double,
    @field:Json(name = "temp_max") val tempMax: Double
)