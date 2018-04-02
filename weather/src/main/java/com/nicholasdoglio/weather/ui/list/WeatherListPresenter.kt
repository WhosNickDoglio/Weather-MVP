package com.nicholasdoglio.weather.ui.list

import com.nicholasdoglio.weather.data.model.WeatherResponse
import com.nicholasdoglio.weather.data.repo.WeatherRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class WeatherListPresenter @Inject constructor(private val weatherRepository: WeatherRepository) :
    WeatherListContract.Presenter {
    private var view: WeatherListContract.View? = null
    private val compositeDisposable = CompositeDisposable()
    private val emptyList = emptyList<WeatherResponse>()

    override fun refreshWeatherListLocations() {
        view?.showLoadingBar()
        view?.hideLoadingBar()
        view?.updateWeatherList(emptyList)
        view?.showEmptyView()
    }

    override fun attach(view: WeatherListContract.View) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

    override fun clearDisposables() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }
}