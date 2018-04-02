package com.nicholasdoglio.weather.data.remote

import com.nicholasdoglio.weather.data.model.ForecastResponse
import com.nicholasdoglio.weather.data.model.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather")
    fun getCurrentWeatherByZip(
        @Query("zip") zip: String,
        @Query("APPID") apikey: String,
        @Query("units") unit: String
    ): Single<WeatherResponse>

    @GET("weather")
    fun getCurrentWeatherByCityName(
        @Query("q") city: String,
        @Query("APPID") apikey: String,
        @Query("units") unit: String
    ): Single<WeatherResponse>


    @GET("group")
    fun getSavedCitiesCurrentWeather(
        @Query("id") vararg id: String,
        @Query("APPID") apikey: String,
        @Query("units") unit: String
    )

    @GET("forecast")
    fun getForecast(
        @Query("id") id: String,
        @Query("APPID") apikey: String,
        @Query("units") unit: String
    ): Single<ForecastResponse>
}