package com.nicholasdoglio.weather.data.response

import com.squareup.moshi.Json

data class WeatherResponse(
    @Json(name = "coord") val coord: Coord,
    @Json(name = "weather") val weather: List<Weather>,
    @Json(name = "main") val main: Main,
    @Json(name = "visibility") val visibility: Int,
    @Json(name = "wind") val wind: Wind,
    @Json(name = "clouds") val clouds: Clouds,
    @Json(name = "dt") val dt: Int,
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String
)