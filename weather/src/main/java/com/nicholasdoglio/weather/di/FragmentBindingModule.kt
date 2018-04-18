package com.nicholasdoglio.weather.di

import com.nicholasdoglio.weather.ui.forecast.ForecastContract
import com.nicholasdoglio.weather.ui.forecast.ForecastFragment
import com.nicholasdoglio.weather.ui.forecast.ForecastPresenter
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
    abstract fun contributesDetailFragment(): ForecastFragment

    @Binds
    abstract fun detailPresenter(forecastPresenter: ForecastPresenter): ForecastContract.Presenter
}