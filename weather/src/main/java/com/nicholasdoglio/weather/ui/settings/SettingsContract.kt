package com.nicholasdoglio.weather.ui.settings

import com.nicholasdoglio.weather.ui.base.BasePresenter
import com.nicholasdoglio.weather.ui.base.BaseView

interface SettingsContract {
    interface Presenter : BasePresenter<View> {

    }

    interface View : BaseView<Presenter> {

    }
}