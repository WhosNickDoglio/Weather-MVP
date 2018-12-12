package com.nicholasdoglio.weather.ui.forecast.pager

import com.nicholasdoglio.weather.ui.base.BasePresenter
import com.nicholasdoglio.weather.ui.base.BaseView

interface ForecastPagerContract {

  interface View : BaseView<Presenter>

  interface Presenter : BasePresenter<View>

}