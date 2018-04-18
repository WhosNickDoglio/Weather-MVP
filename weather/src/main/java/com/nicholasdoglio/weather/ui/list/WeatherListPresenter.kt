package com.nicholasdoglio.weather.ui.list

import com.nicholasdoglio.weather.data.entities.CurrentWeather
import com.nicholasdoglio.weather.data.repo.WeatherRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author Nicholas Doglio
 */
class WeatherListPresenter @Inject constructor(private val weatherRepository: WeatherRepository) :
    WeatherListContract.Presenter {

    private var weatherListView: WeatherListContract.View? = null
    private val compositeDisposable = CompositeDisposable()

    override fun addLocationToList(lat: Double, long: Double) {
        weatherListView?.showLoadingBar()
        compositeDisposable += weatherRepository.getWeather(lat, long)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ handleAddLocationSuccess(it) }, { handleError(it) })
    }

    override fun refreshWeatherListLocations() {
        weatherListView?.showLoadingBar()
        compositeDisposable += weatherRepository.updateWeatherList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ handleRefreshListSuccess() }, { handleError(it) })
    }

    override fun getWeatherInformation() {
        weatherListView?.showLoadingBar()
        compositeDisposable += weatherRepository.getWeatherList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ handleGetWeatherInformationSuccess(it) }, { handleError(it) })
    }

    override fun attach(view: WeatherListContract.View) {
        this.weatherListView = view
    }

    override fun detach() {
        weatherListView = null
    }

    override fun clearDisposables() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }

    private fun handleRefreshListSuccess() {
        weatherListView?.hideLoadingBar()
        weatherListView?.listUpdated()
    }

    private fun handleAddLocationSuccess(currentWeather: CurrentWeather) {
        weatherListView?.hideLoadingBar()
        when (weatherRepository.addLocation(currentWeather)) {
            true -> weatherListView?.locationAdded()
            false -> weatherListView?.listTooLong()
        }
    }

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