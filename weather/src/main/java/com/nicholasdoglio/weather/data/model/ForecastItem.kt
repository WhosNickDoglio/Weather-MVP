package com.nicholasdoglio.weather.data.model

import com.squareup.moshi.Json

data class ForecastItem(

    @Json(name = "dt")
    val dt: Int,

    @Json(name = "dt_txt")
    val dtTxt: String,

    @Json(name = "weather")
    val weather: List<WeatherItem>,

    @Json(name = "main")
    val forecastMain: ForecastMain,

    @Json(name = "clouds")
    val clouds: Clouds,

    @Json(name = "sys")
    val forecastSys: ForecastSys,

    @Json(name = "wind")
    val wind: Wind
)