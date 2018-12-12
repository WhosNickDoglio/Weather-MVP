package com.nicholasdoglio.weather.ui.forecast.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nicholasdoglio.weather.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_forecast.detailSwipeToRefresh
import javax.inject.Inject

/**
 * @author Nicholas Doglio
 */
class ForecastFragment : DaggerFragment(),
  ForecastContract.View {

  //TODO look into weather icons from material design icons

  @Inject lateinit var forecastPresenter: ForecastContract.Presenter

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? = inflater.inflate(R.layout.fragment_forecast, container, false)

  override fun onStart() {
    super.onStart()
    forecastPresenter.attach(this)
  }

  override fun onStop() {
    super.onStop()
    forecastPresenter.clearDisposables()
  }

  override fun onDestroy() {
    super.onDestroy()
    forecastPresenter.detach()
  }

  override fun showLoadingBar() {
    detailSwipeToRefresh.isRefreshing = true
  }

  override fun hideLoadingBar() {
    detailSwipeToRefresh.isRefreshing = false
  }

  companion object {
    private const val FORECAST_ID = "FORECAST_ID"

    fun create(id: Int): ForecastFragment = ForecastFragment()
      .apply {
        arguments = Bundle().apply {
          putInt(FORECAST_ID, id)
        }
      }
  }
}