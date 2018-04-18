package com.nicholasdoglio.weather.ui.list

import com.nicholasdoglio.weather.data.entities.CurrentWeather
import com.nicholasdoglio.weather.ui.base.BasePresenter
import com.nicholasdoglio.weather.ui.base.BaseView

/**
 * @author Nicholas Doglio
 */
interface WeatherListContract {
    interface Presenter : BasePresenter<View> {

        fun addLocationToList(lat: Double, long: Double)

        fun refreshWeatherListLocations()

        fun getWeatherInformation()
    }

    interface View : BaseView<Presenter> {

        fun submitList(weatherList: List<CurrentWeather>)

        fun showEmptyView()

        fun locationAdded()

        fun listTooLong()

        fun listUpdated()
    }
}