package com.nicholasdoglio.weather.util

import com.nicholasdoglio.weather.BuildConfig

object Constants {
    const val WEATHER_BASE_URL = "https://api.openweathermap.org/data/2.5/"
    const val IMPERIAL_UNITS = "imperial"
    const val METRIC_UNITS = "metric"
    val WEATHER_API_KEY = BuildConfig.API_KEY
}