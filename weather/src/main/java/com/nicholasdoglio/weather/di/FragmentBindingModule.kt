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

package com.nicholasdoglio.weather.di

import com.nicholasdoglio.weather.ui.forecast.details.ForecastContract
import com.nicholasdoglio.weather.ui.forecast.details.ForecastFragment
import com.nicholasdoglio.weather.ui.forecast.details.ForecastPresenter
import com.nicholasdoglio.weather.ui.list.WeatherListContract
import com.nicholasdoglio.weather.ui.list.WeatherListFragment
import com.nicholasdoglio.weather.ui.list.WeatherListPresenter
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Nicholas Doglio
 */
@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun contributesListFragment(): WeatherListFragment

    @Binds
    abstract fun listPresenter(weatherListPresenter: WeatherListPresenter): WeatherListContract.Presenter

    @ContributesAndroidInjector
    abstract fun contributesForecastFragment(): ForecastFragment

    @Binds
    abstract fun forecastPresenter(forecastPresenter: ForecastPresenter): ForecastContract.Presenter
}