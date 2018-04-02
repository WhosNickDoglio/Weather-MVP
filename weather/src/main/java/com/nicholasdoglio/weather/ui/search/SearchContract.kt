package com.nicholasdoglio.weather.ui.search

import com.nicholasdoglio.weather.ui.base.BasePresenter
import com.nicholasdoglio.weather.ui.base.BaseView

interface SearchContract {
    interface Presenter : BasePresenter<View> {

        fun submitSearch(query: String)

    }

    interface View : BaseView<Presenter> {

    }
}