package com.nicholasdoglio.weather.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
  @Json(name = "dt") val dt: Int,
  @Json(name = "main") val main: Main,
  @Json(name = "weather") val weather: List<Weather>,
  @Json(name = "clouds") val clouds: Clouds,
  @Json(name = "wind") val wind: Wind,
  @Json(name = "rain") val rain: Rain,
  @Json(name = "dt_txt") val dtTxt: String
)