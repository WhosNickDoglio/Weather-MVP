package com.nicholasdoglio.weather.ui

import android.os.Bundle
import com.nicholasdoglio.weather.R
import com.nicholasdoglio.weather.ui.common.NavigationController
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * @author Nicholas Doglio
 */
class MainActivity : DaggerAppCompatActivity(), HasSupportFragmentInjector {

  @Inject
  lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<androidx.fragment.app.Fragment>

  @Inject lateinit var navigationController: NavigationController

  override fun supportFragmentInjector(): DispatchingAndroidInjector<androidx.fragment.app.Fragment> =
    dispatchingAndroidInjector

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    if (savedInstanceState == null) navigationController.openWeatherListFragment()
  }
}