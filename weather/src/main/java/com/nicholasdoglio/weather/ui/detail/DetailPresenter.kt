package com.nicholasdoglio.weather.ui.detail

import com.nicholasdoglio.weather.data.repo.WeatherRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DetailPresenter @Inject constructor(private val weatherRepository: WeatherRepository) :
    DetailContract.Presenter {
    private var view: DetailContract.View? = null
    private val compositeDisposable = CompositeDisposable()


    override fun attach(view: DetailContract.View) {
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