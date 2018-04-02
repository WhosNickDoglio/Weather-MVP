package com.nicholasdoglio.weather.data.model

import com.squareup.moshi.Json

data class ForecastSys(

    @Json(name = "pod")
    val pod: String
)