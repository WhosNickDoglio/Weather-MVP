package com.nicholasdoglio.weather.di

import com.nicholasdoglio.weather.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityBindingModule {
    @ContributesAndroidInjector(modules = [FragmentBindingModule::class])
    abstract fun contributesMainActivity(): MainActivity
}