package com.nicholasdoglio.weather.ui.common

import com.nicholasdoglio.weather.R
import com.nicholasdoglio.weather.ui.MainActivity
import com.nicholasdoglio.weather.ui.list.WeatherListFragment
import com.nicholasdoglio.weather.ui.search.SearchFragment
import javax.inject.Inject

/**
 * @author Nicholas Doglio
 */
class NavigationController @Inject constructor(mainActivity: MainActivity) {
    private val containerId = R.id.fragmentContainer
    private val fragmentManager = mainActivity.supportFragmentManager

    fun openSearch() {
        val searchFragment = SearchFragment()
        fragmentManager.beginTransaction()
            .replace(containerId, searchFragment)
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }

    fun openList() {
        val listFragment = WeatherListFragment()
        fragmentManager.beginTransaction()
            .replace(containerId, listFragment)
            .commitAllowingStateLoss()

    }

    fun openDetail() {

    }

    fun openSettings() {

    }
}