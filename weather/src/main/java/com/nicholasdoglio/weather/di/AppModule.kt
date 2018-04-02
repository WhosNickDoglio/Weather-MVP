package com.nicholasdoglio.weather.di

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
    fun weatherService() = Retrofit.Builder()
        .baseUrl(Constants.WEATHER_BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(WeatherService::class.java)

    @Singleton
    @Provides
    fun repository(weatherService: WeatherService) = WeatherRepository(weatherService)
}