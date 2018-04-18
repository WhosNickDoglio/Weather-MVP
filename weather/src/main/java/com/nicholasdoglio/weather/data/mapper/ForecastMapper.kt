package com.nicholasdoglio.weather.data.mapper

import com.nicholasdoglio.weather.data.entities.Forecast
import com.nicholasdoglio.weather.data.model.ForecastResponse

class ForecastMapper() : Mapper<ForecastResponse, Forecast> {
    override fun mapFromResponse(response: ForecastResponse): Forecast {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}