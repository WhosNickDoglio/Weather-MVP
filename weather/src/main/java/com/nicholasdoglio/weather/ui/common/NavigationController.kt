package com.nicholasdoglio.weather.ui.common

import com.google.android.gms.common.api.Status
import com.google.android.gms.location.places.AutocompleteFilter
import com.google.android.gms.location.places.Place
import com.google.android.gms.location.places.ui.PlaceSelectionListener
import com.google.android.gms.location.places.ui.SupportPlaceAutocompleteFragment
import com.nicholasdoglio.weather.R
import com.nicholasdoglio.weather.ui.MainActivity
import com.nicholasdoglio.weather.ui.forecast.details.ForecastFragment
import com.nicholasdoglio.weather.ui.list.WeatherListFragment
import timber.log.Timber
import javax.inject.Inject


/**
 * @author Nicholas Doglio
 */
class NavigationController @Inject constructor(private val mainActivity: MainActivity) {
    private val containerId = R.id.fragmentContainer
    private val fragmentManager = mainActivity.supportFragmentManager

    //TODO transitions
    fun openWeatherListFragment(latitude: Double = 0.0, longitude: Double = 0.0) {
        fragmentManager.beginTransaction()
            .replace(containerId, WeatherListFragment.create(latitude, longitude))
            .commitAllowingStateLoss()
    }

    fun openOnboardingFragment() {

    }

    fun openForecastFragment(id: Int) {
        fragmentManager.beginTransaction()
            .replace(containerId, ForecastFragment.create(id))
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }

    fun openAboutFragment() {
        //TODO Dialog fragment
    }

    fun openSearchFragment() {
        //TODO can I make this better?
        val placesFragment = SupportPlaceAutocompleteFragment()

        val typeFilter = AutocompleteFilter.Builder()
            .setTypeFilter(AutocompleteFilter.TYPE_FILTER_CITIES)
            .build()

        placesFragment.setFilter(typeFilter)

        placesFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place?) {
                Timber.d(("lat: ${place?.latLng?.latitude} long: ${place?.latLng?.longitude}"))
                openWeatherListFragment(place!!.latLng.latitude, place.latLng.longitude)
            }

            override fun onError(error: Status?) {
                Timber.d("${error?.statusCode}")
            }
        })

        fragmentManager.beginTransaction()
            .replace(containerId, PlacesFragment())
            .addToBackStack(null)
            .commit()
    }
}