package com.nicholasdoglio.weather.ui.detail

import com.nicholasdoglio.weather.ui.base.BasePresenter
import com.nicholasdoglio.weather.ui.base.BaseView

interface DetailContract {

    interface Presenter : BasePresenter<View> {

    }

    interface View : BaseView<Presenter> {

    }
}