package com.nicholasdoglio.weather.data.mapper

import com.nicholasdoglio.weather.data.model.Forecast
import com.nicholasdoglio.weather.data.response.ForecastResponse
import javax.inject.Inject

class ForecastMapper @Inject constructor() : Mapper<ForecastResponse, Forecast> {
    override fun mapFromResponse(response: ForecastResponse): Forecast {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}