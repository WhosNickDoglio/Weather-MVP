package com.nicholasdoglio.weather.data.model

import com.squareup.moshi.Json

data class WeatherResponse(

    @Json(name = "dt")
    val dt: Int,

    @Json(name = "coord")
    val coordinates: Coordinates,

    @Json(name = "weather")
    val weather: List<WeatherItem>,

    @Json(name = "name")
    val name: String,

    @Json(name = "cod")
    val cod: Int,

    @Json(name = "main")
    val currentMain: CurrentMain,

    @Json(name = "clouds")
    val clouds: Clouds,

    @Json(name = "id")
    val id: Int,

    @Json(name = "sys")
    val sys: CurrentSys,

    @Json(name = "base")
    val base: String,

    @Json(name = "wind")
    val wind: Wind
)