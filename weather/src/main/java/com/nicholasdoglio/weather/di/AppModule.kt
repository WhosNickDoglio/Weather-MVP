package com.nicholasdoglio.weather.di

import android.app.Application
import android.arch.persistence.room.Room
import com.nicholasdoglio.weather.data.local.LocalDataSource
import com.nicholasdoglio.weather.data.local.WeatherDatabase
import com.nicholasdoglio.weather.data.mapper.CurrentWeatherMapper
import com.nicholasdoglio.weather.data.mapper.ForecastMapper
import com.nicholasdoglio.weather.data.remote.RemoteDataSource
import com.nicholasdoglio.weather.data.remote.WeatherService
import com.nicholasdoglio.weather.data.repo.WeatherRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * @author Nicholas Doglio
 */
@Module
class AppModule {

    private val baseUrl = "https://api.openweathermap.org/data/2.5/"

    @Provides
    fun interceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun OkhttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(interceptor).build()


    @Singleton
    @Provides
    fun weatherService(okHttpClient: OkHttpClient): WeatherService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(WeatherService::class.java)

    @Singleton
    @Provides
    fun weatherDatabase(app: Application): WeatherDatabase =
        Room.databaseBuilder(app, WeatherDatabase::class.java, "weather.db").build();

    @Singleton
    @Provides
    fun localDataSource(weatherDatabase: WeatherDatabase) = LocalDataSource(weatherDatabase)

    @Provides
    fun currentWeatherMapper() = CurrentWeatherMapper()

    @Provides
    fun forecastMapper() = ForecastMapper()

    @Singleton
    @Provides
    fun remoteDataSource(
        weatherService: WeatherService,
        currentWeatherMapper: CurrentWeatherMapper,
        forecastMapper: ForecastMapper
    ) = RemoteDataSource(weatherService, currentWeatherMapper, forecastMapper)

    @Singleton
    @Provides
    fun repository(localDataSource: LocalDataSource, remoteDataSource: RemoteDataSource) =
        WeatherRepository(remoteDataSource, localDataSource)
}