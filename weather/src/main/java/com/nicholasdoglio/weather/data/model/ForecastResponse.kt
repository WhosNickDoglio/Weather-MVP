package com.nicholasdoglio.weather.data.model

import com.squareup.moshi.Json

data class ForecastResponse(

    @Json(name = "city")
    val city: City
)