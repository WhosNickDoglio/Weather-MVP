package com.nicholasdoglio.weather.data.repo

interface Repository {

    fun getWeatherByZip(zip: String)

    fun getWeatherByCityName(name: String)

    fun updateWeatherList()

    fun getForecast(id: String)
}