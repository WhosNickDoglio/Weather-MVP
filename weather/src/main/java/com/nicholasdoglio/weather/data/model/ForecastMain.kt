package com.nicholasdoglio.weather.data.model

import com.squareup.moshi.Json

data class ForecastMain(

    @Json(name = "temp")
    val temp: Double,

    @Json(name = "temp_min")
    val tempMin: Double,

    @Json(name = "grnd_level")
    val grndLevel: Double,

    @Json(name = "temp_kf")
    val tempKf: Double,

    @Json(name = "humidity")
    val humidity: Int,

    @Json(name = "pressure")
    val pressure: Double,

    @Json(name = "sea_level")
    val seaLevel: Double,

    @Json(name = "temp_max")
    val tempMax: Double
)