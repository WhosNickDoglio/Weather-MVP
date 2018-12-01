package com.nicholasdoglio.weather.ui.forecast.pager

class ForecastPagerPresenter() : ForecastPagerContract.Presenter {

    private var view: ForecastPagerContract.View? = null

    override fun attach(view: ForecastPagerContract.View) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

    override fun clearDisposables() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}