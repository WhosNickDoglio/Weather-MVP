package com.nicholasdoglio.remote

import com.nicholasdoglio.remote.response.ForecastResponse
import com.nicholasdoglio.remote.response.ListOfCitiesResponse
import com.nicholasdoglio.remote.response.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Nicholas Doglio
 */
interface WeatherService {

  @GET("weather")
  fun getWeather(
    @Query("lat") lat: Double,
    @Query("lon") lon: Double,
    @Query("APPID") apikey: String,
    @Query("units") unit: String
  ): Single<WeatherResponse>

  @GET("group")
  fun getSavedCitiesCurrentWeather(
    @Query("id") id: String,
    @Query("APPID") apikey: String,
    @Query("units") unit: String
  ): Single<ListOfCitiesResponse>

  @GET("forecast")
  fun getForecast(
    @Query("id") id: String,
    @Query("APPID") apikey: String,
    @Query("units") unit: String
  ): Single<ForecastResponse>
}