package com.nicholasdoglio.weather.data.model

import com.squareup.moshi.Json

data class ListOfCitiesResponse(
    @Json(name = "cnt") val cnt: Int,
    @Json(name = "list") val list: List<WeatherResponse>
)
