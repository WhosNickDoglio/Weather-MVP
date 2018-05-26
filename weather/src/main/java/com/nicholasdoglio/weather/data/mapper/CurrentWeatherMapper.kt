package com.nicholasdoglio.weather.data.mapper

import com.nicholasdoglio.weather.R
import com.nicholasdoglio.weather.data.model.CurrentWeather
import com.nicholasdoglio.weather.data.response.WeatherResponse

class CurrentWeatherMapper() : Mapper<WeatherResponse, CurrentWeather> {

    override fun mapFromResponse(response: WeatherResponse): CurrentWeather {
        return CurrentWeather(
            id = response.id,
            locationName = response.name,
            currentTemp = response.main.temp,
            weatherImage = R.mipmap.ic_launcher_round //TODO fix this
        )
    }
}