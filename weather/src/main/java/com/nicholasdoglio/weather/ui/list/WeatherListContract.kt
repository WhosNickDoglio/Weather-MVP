package com.nicholasdoglio.weather.ui.list

import com.nicholasdoglio.weather.data.model.WeatherResponse
import com.nicholasdoglio.weather.ui.base.BasePresenter
import com.nicholasdoglio.weather.ui.base.BaseView

interface WeatherListContract {
    interface Presenter : BasePresenter<View> {

        fun refreshWeatherListLocations()

    }

    interface View : BaseView<Presenter> {

        fun updateWeatherList(weatherList: List<WeatherResponse>)

        fun showEmptyView()


    }
}