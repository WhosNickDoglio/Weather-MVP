package com.nicholasdoglio.remote.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ListOfCitiesResponse(
  @Json(name = "cnt") val cnt: Int,
  @Json(name = "list") val list: List<WeatherResponse>
)
