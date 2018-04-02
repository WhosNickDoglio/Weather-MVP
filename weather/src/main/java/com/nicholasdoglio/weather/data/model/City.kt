package com.nicholasdoglio.weather.data.model

import com.squareup.moshi.Json

data class City(

    @Json(name = "country")
    val country: String,

    @Json(name = "coord")
    val coordinates: Coordinates,

    @Json(name = "name")
    val name: String,

    @Json(name = "cnt")
    val cnt: Int,

    @Json(name = "cod")
    val cod: String,

    @Json(name = "id")
    val id: Int,

    @Json(name = "message")
    val message: Double,

    @Json(name = "forecast")
    val forecast: List<ForecastItem>
)