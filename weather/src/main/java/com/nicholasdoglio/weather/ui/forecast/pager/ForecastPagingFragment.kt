package com.nicholasdoglio.weather.ui.forecast.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nicholasdoglio.weather.R
import dagger.android.support.DaggerFragment

class ForecastPagingFragment : DaggerFragment(), ForecastPagerContract.View {
  override fun showLoadingBar() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun hideLoadingBar() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_forecast_paging, container, false)
  }

}
