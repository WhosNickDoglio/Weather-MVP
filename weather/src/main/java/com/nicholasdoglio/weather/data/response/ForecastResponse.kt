package com.nicholasdoglio.weather.data.response

import com.squareup.moshi.Json

data class ForecastResponse(
    @Json(name = "cod") val cod: String,
    @Json(name = "message") val message: Double,
    @Json(name = "cnt") val cnt: Int,
    @Json(name = "list") val list: List<Item>,
    @Json(name = "city") val city: City
)