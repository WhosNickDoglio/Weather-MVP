package com.nicholasdoglio.weather.ui.forecast

import com.nicholasdoglio.weather.ui.base.BasePresenter
import com.nicholasdoglio.weather.ui.base.BaseView

/**
 * @author Nicholas Doglio
 */
interface ForecastContract {

    interface Presenter : BasePresenter<View> {

    }

    interface View : BaseView<Presenter> {

    }
}