package com.nicholasdoglio.weather.di

import android.app.Application
import android.arch.persistence.room.Room
import com.nicholasdoglio.weather.data.local.WeatherDatabase
import com.nicholasdoglio.weather.data.remote.WeatherService
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
@Module object AppModule {

    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    @Provides @JvmStatic fun interceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton @Provides @JvmStatic
    fun okhttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(interceptor).build()


    @Singleton @Provides @JvmStatic fun weatherService(okHttpClient: OkHttpClient): WeatherService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(WeatherService::class.java)

    @Singleton @Provides @JvmStatic fun weatherDatabase(app: Application): WeatherDatabase =
        Room.databaseBuilder(app, WeatherDatabase::class.java, "weather.db").build();
}