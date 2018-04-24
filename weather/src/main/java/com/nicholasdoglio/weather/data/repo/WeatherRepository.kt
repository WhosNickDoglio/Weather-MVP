package com.nicholasdoglio.weather.data.repo

import com.nicholasdoglio.weather.data.entities.CurrentWeather
import com.nicholasdoglio.weather.data.entities.Forecast
import com.nicholasdoglio.weather.data.local.LocalDataSource
import com.nicholasdoglio.weather.data.remote.RemoteDataSource
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : Repository {

    override fun addLocation(lat: Double, long: Double): Completable {
        return remoteDataSource.getWeather(lat, long)
            .flatMapCompletable { localDataSource.addCityToList(it) }
    }

    override fun removeLocation(currentWeather: CurrentWeather): Completable {
        return localDataSource.removeCity(currentWeather)
    }

    override fun getWeather(id: Int): Single<CurrentWeather> {
        return localDataSource.getCityById(id)
    }

    //This doesn't work
    override fun updateWeatherList(): Completable = localDataSource.getCityIds()
        .flatMap { listOfIds -> remoteDataSource.getUpdatesForList(listOfIds) }
        .flatMapCompletable { localDataSource.addListOFCitiesToList(it) }

    override fun getWeatherList(): Flowable<List<CurrentWeather>> {
        return localDataSource.getCurrentWeatherList()
    }

    override fun getForecast(id: String): Single<Forecast> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        // SwitchIfEmpty

    }
}

//TODO label the time the weather/forecast is being pulled