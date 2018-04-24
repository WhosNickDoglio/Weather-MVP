package com.nicholasdoglio.weather.ui.forecast

import com.nicholasdoglio.weather.data.repo.WeatherRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * @author Nicholas Doglio
 */
class ForecastPresenter @Inject constructor(private val weatherRepository: WeatherRepository) :
    ForecastContract.Presenter {
    private var view: ForecastContract.View? = null
    private val compositeDisposable = CompositeDisposable()


    override fun attach(view: ForecastContract.View) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

    override fun clearDisposables() {
        compositeDisposable.clear()
    }
}