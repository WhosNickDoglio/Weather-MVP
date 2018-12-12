package com.nicholasdoglio.weather.ui.list

import com.nicholasdoglio.weather.data.model.CurrentWeather
import com.nicholasdoglio.weather.ui.base.BasePresenter
import com.nicholasdoglio.weather.ui.base.BaseView

/**
 * @author Nicholas Doglio
 */
interface WeatherListContract {
  interface Presenter : BasePresenter<View> {

    fun addLocationToList(lat: Double, long: Double)

    fun refreshWeatherListLocations()

    fun observeWeatherList()

    fun observeNumberOfLocations()
  }

  interface View : BaseView<Presenter> {

    fun submitList(weatherList: List<CurrentWeather>)

    fun showEmptyView()

    fun showList()

    fun locationAdded()

    fun listTooLong()

    fun listUpdated()
  }
}