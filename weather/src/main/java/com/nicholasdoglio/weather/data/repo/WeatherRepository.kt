package com.nicholasdoglio.weather.data.repo

import com.nicholasdoglio.weather.data.remote.WeatherService
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherService: WeatherService) :
    Repository {

    override fun getWeatherByZip(zip: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWeatherByCityName(name: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateWeatherList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getForecast(id: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}