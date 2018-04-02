package com.nicholasdoglio.weather.di

import com.nicholasdoglio.weather.ui.detail.DetailContract
import com.nicholasdoglio.weather.ui.detail.DetailFragment
import com.nicholasdoglio.weather.ui.detail.DetailPresenter
import com.nicholasdoglio.weather.ui.list.WeatherListContract
import com.nicholasdoglio.weather.ui.list.WeatherListFragment
import com.nicholasdoglio.weather.ui.list.WeatherListPresenter
import com.nicholasdoglio.weather.ui.search.SearchContract
import com.nicholasdoglio.weather.ui.search.SearchFragment
import com.nicholasdoglio.weather.ui.search.SearchPresenter
import com.nicholasdoglio.weather.ui.settings.SettingsContract
import com.nicholasdoglio.weather.ui.settings.SettingsFragment
import com.nicholasdoglio.weather.ui.settings.SettingsPresenter
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {
    @ContributesAndroidInjector
    abstract fun contributesSearchFragment(): SearchFragment

    @Binds
    abstract fun searchPresenter(searchPresenter: SearchPresenter): SearchContract.Presenter

    @ContributesAndroidInjector
    abstract fun contributesListFragment(): WeatherListFragment

    @Binds
    abstract fun listPresenter(weatherListPresenter: WeatherListPresenter): WeatherListContract.Presenter

    @ContributesAndroidInjector
    abstract fun contributesDetailFragment(): DetailFragment

    @Binds
    abstract fun detailPresenter(detailPresenter: DetailPresenter): DetailContract.Presenter

    @ContributesAndroidInjector
    abstract fun contributesSettingFragment(): SettingsFragment

    @Binds
    abstract fun settingsPresenter(settingsPresenter: SettingsPresenter): SettingsContract.Presenter


}