package com.nicholasdoglio.weather.data.model

import com.squareup.moshi.Json

data class City(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "coord") val coord: Coord,
    @Json(name = "country") val country: String
)