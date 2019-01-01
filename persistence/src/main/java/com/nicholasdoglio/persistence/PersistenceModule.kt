package com.nicholasdoglio.persistence

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Nicholas Doglio
 */
@Module
object PersistenceModule {

  @Singleton @Provides @JvmStatic internal fun weatherDatabase(app: Application): WeatherDatabase =
    Room.databaseBuilder(app, WeatherDatabase::class.java, "weather.db").build()
}