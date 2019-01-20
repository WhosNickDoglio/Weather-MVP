/*
 * MIT License
 *
 * Copyright (c) 2019 Nicholas Doglio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/*
 * MIT License
 *
 * Copyright (c) 2019 Nicholas Doglio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/*
package com.nicholasdoglio.data.repo

import com.nicholasdoglio.data.model.CurrentWeather
import com.nicholasdoglio.data.model.Forecast
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(
//  private val remoteDataSource: RemoteDataSource,
//  private val localDataSource: LocalDataSource
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

  override fun observeWeatherLocations(): Flowable<List<CurrentWeather>> {
    return localDataSource.getCurrentWeatherList()
  }

  override fun observeNumberOfLocations(): Flowable<Int> {
    return localDataSource.getNumberOfCitiesInList()
  }

  override fun getForecast(id: String): Single<Forecast> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    // SwitchIfEmpty
  }
}

//TODO label the time the weather/forecast is being pulled*/
