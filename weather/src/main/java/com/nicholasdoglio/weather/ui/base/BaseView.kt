package com.nicholasdoglio.weather.ui.base

/**
 * @author Nicholas Doglio
 */
interface BaseView<T> {
  fun showLoadingBar()

  fun hideLoadingBar()
}