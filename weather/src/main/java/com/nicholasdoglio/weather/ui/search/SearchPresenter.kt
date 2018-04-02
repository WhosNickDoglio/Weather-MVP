package com.nicholasdoglio.weather.ui.search

import com.nicholasdoglio.weather.data.repo.WeatherRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SearchPresenter @Inject constructor(private val weatherRepository: WeatherRepository) :
    SearchContract.Presenter {
    private var view: SearchContract.View? = null
    private val compositeDisposable = CompositeDisposable()


    override fun submitSearch(query: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun attach(view: SearchContract.View) {
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