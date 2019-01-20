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

package com.nicholasdoglio.weather.ui.list

import com.nicholasdoglio.weather.data.model.CurrentWeather
import io.reactivex.disposables.CompositeDisposable

/**
 * @author Nicholas Doglio
 */
class WeatherListPresenter : WeatherListContract.Presenter {

    private var weatherListView: WeatherListContract.View? = null
    private val compositeDisposable = CompositeDisposable()

    override fun attach(view: WeatherListContract.View) {
        this.weatherListView = view
    }

    override fun detach() {
        weatherListView = null
    }

    override fun clearDisposables() {
        compositeDisposable.clear()
    }

    override fun addLocationToList(lat: Double, long: Double) {
        weatherListView?.showLoadingBar()
//        compositeDisposable += weatherRepository.addLocation(lat, long)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ handleLocationAdded() }, { handleError(it) })
    }

    override fun refreshWeatherListLocations() {
        weatherListView?.showLoadingBar()
//        compositeDisposable += weatherRepository.updateWeatherList()
//            .subscribeOn(Schedulers.io())
//            .subscribe({ handleRefreshListSuccess() }, { handleError(it) })
    }

    override fun observeNumberOfLocations() {
//        compositeDisposable += weatherRepository.observeNumberOfLocations()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ handleNumberOfLocations(it) }, { it.printStackTrace() })
    }

    override fun observeWeatherList() {
        weatherListView?.showLoadingBar()
//        compositeDisposable += weatherRepository.observeWeatherLocations()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ handleGetWeatherInformationSuccess(it) }, { handleError(it) })
    }

    private fun handleLocationAdded() {
        weatherListView?.hideLoadingBar()
        weatherListView?.listUpdated()
    }

    private fun handleRefreshListSuccess() {
        weatherListView?.hideLoadingBar()
        weatherListView?.listUpdated()
    }

    private fun handleAddLocationSuccess(currentWeather: CurrentWeather) {
        weatherListView?.hideLoadingBar()
    }

    private fun handleNumberOfLocations(numOfLocations: Int) {
        when (numOfLocations > 0) {
            true -> weatherListView?.showList()
            false -> weatherListView?.showEmptyView()
        }
    }

    //TODO I need to connect this to Room
    private fun handleGetWeatherInformationSuccess(currentWeather: List<CurrentWeather>) {
        weatherListView?.hideLoadingBar()
        when (currentWeather.isEmpty()) {
            true -> weatherListView?.showEmptyView()
            false -> weatherListView?.submitList(currentWeather)
        }
    }

    private fun handleError(error: Throwable) {
        weatherListView?.hideLoadingBar()
        error.printStackTrace()
    }
}