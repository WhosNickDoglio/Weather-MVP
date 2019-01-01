package com.nicholasdoglio.remote

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
object NetworkModule {

  private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

  @Provides @JvmStatic internal fun interceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply {
      level = HttpLoggingInterceptor.Level.BODY
    }

  @Singleton @Provides @JvmStatic
  internal fun okhttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient.Builder().addInterceptor(interceptor).build()

  @Singleton @Provides @JvmStatic
  internal fun weatherService(okHttpClient: OkHttpClient): WeatherService =
    Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .addConverterFactory(MoshiConverterFactory.create())
      .client(okHttpClient)
      .build()
      .create()
}