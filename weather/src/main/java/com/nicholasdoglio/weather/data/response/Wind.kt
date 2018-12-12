package com.nicholasdoglio.weather.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Wind(
  @Json(name = "speed") val speed: Double,
  @Json(name = "deg") val deg: Double
)