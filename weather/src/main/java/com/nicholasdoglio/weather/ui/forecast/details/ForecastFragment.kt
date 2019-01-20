/*
 * MIT License
 *
 * Copyright (c) 2019 Nicholas Doglio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.nicholasdoglio.weather.ui.forecast.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nicholasdoglio.weather.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_forecast.*
import javax.inject.Inject

/**
 * @author Nicholas Doglio
 */
class ForecastFragment : DaggerFragment(),
    ForecastContract.View {

    //TODO look into weather icons from material design icons

    @Inject
    lateinit var forecastPresenter: ForecastContract.Presenter

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