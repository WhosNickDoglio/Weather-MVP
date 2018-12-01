package com.nicholasdoglio.weather.ui.common

import android.content.Context
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.places.AutocompleteFilter
import com.google.android.gms.location.places.Place
import com.google.android.gms.location.places.ui.PlaceSelectionListener
import com.google.android.gms.location.places.ui.SupportPlaceAutocompleteFragment
import dagger.android.support.AndroidSupportInjection
import timber.log.Timber
import javax.inject.Inject

//TODO maybe I can make this work?
class PlacesFragment() : SupportPlaceAutocompleteFragment() {

    @Inject lateinit var navigationController: NavigationController

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun setFilter(p0: AutocompleteFilter?) {
        val typeFilter = AutocompleteFilter.Builder()
            .setTypeFilter(AutocompleteFilter.TYPE_FILTER_CITIES)
            .build()

        super.setFilter(typeFilter)


    }

    override fun setOnPlaceSelectedListener(p0: PlaceSelectionListener?) {
        super.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place?) {
                Timber.d(("lat: ${place?.latLng?.latitude} long: ${place?.latLng?.longitude}"))
                navigationController.openWeatherListFragment(
                    place!!.latLng.latitude,
                    place.latLng.longitude
                )

            }

            override fun onError(error: Status?) {
                Timber.d("${error?.statusCode}")
            }

        })
    }
}