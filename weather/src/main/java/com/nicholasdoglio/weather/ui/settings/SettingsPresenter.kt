package com.nicholasdoglio.weather.ui.settings

import com.nicholasdoglio.weather.data.repo.WeatherRepository
import javax.inject.Inject

class SettingsPresenter @Inject constructor(private val weatherRepository: WeatherRepository) :
    SettingsContract.Presenter {
    override fun attach(view: SettingsContract.View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun detach() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearDisposables() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}