package com.nicholasdoglio.weather.di

import android.app.Application
import android.arch.persistence.room.Room
import com.nicholasdoglio.weather.data.local.WeatherDatabase
import com.nicholasdoglio.weather.data.mapper.CurrentWeatherMapper
import com.nicholasdoglio.weather.data.mapper.ForecastMapper
import com.nicholasdoglio.weather.data.remote.WeatherService
import com.nicholasdoglio.weather.data.repo.WeatherRepository
import com.nicholasdoglio.weather.util.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * @author Nicholas Doglio
 */
@Module
class AppModule {

    @Singleton
    @Provides
    fun weatherService(): WeatherService = Retrofit.Builder()
        .baseUrl(Constants.WEATHER_BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(WeatherService::class.java)

    @Singleton
    @Provides
    fun weatherDatabase(app: Application): WeatherDatabase =
        Room.databaseBuilder(app, WeatherDatabase::class.java, "weather.db").build();

    @Provides
    fun currentWeatherMapper() = CurrentWeatherMapper()

    @Provides
    fun forecastMapper() = ForecastMapper()

    @Singleton
    @Provides
    fun repository(
        weatherService: WeatherService,
        currentWeatherMapper: CurrentWeatherMapper,
        forecastMapper: ForecastMapper,
        weatherDatabase: WeatherDatabase
    ) = WeatherRepository(weatherService, currentWeatherMapper, forecastMapper, weatherDatabase)
}