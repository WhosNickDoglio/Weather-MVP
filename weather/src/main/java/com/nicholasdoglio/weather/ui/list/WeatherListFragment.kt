package com.nicholasdoglio.weather.ui.list


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import android.widget.Toast
import com.nicholasdoglio.weather.R
import com.nicholasdoglio.weather.data.model.CurrentWeather
import com.nicholasdoglio.weather.ui.common.NavigationController
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_weather_list.*
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Nicholas Doglio
 */
class WeatherListFragment : DaggerFragment(), WeatherListContract.View {

    @Inject lateinit var navigationController: NavigationController
    @Inject lateinit var weatherListPresenter: WeatherListContract.Presenter

    private lateinit var weatherListAdapter: WeatherListAdapter

    private var lat: Double? = null

    //TODO last updated header in RecyclerView and footer "Powered by OpenWeatherMap"

    private var long: Double? = null
    //TODO Spanish cities are broken
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        weatherListAdapter = WeatherListAdapter(navigationController)

        arguments?.let {
            lat = arguments?.getDouble(LAT_KEY)
            long = arguments?.getDouble(LONG_KEY)
            if (lat != 0.0 && long != 0.0) {
                weatherListPresenter.addLocationToList(lat!!, long!!)
                Timber.d(("Coordinates Lat: ${lat} Long: ${long}"))
            }
        }

        val mainActivity = activity as AppCompatActivity

        mainActivity.apply {
            setSupportActionBar(listToolbar)
            supportActionBar?.setDisplayShowTitleEnabled(false)
        }

        listToolbar.title = "Locations"
        setHasOptionsMenu(true)

        weatherList.apply {
            adapter = weatherListAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_weather_list, container, false)

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.weather_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
    //TODO set up F v C in menu
        R.id.about_item -> {
//            navigationController.openAboutFragment()
            true
        }

        else -> super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        weatherListPresenter.attach(this)
        weatherListPresenter.observeNumberOfLocations()
        weatherListPresenter.observeWeatherList()
        weatherListSwipeToRefresh.setOnRefreshListener { weatherListPresenter.refreshWeatherListLocations() }
        seachFab.setOnClickListener { navigationController.openSearchFragment() }
    }

    override fun onStop() {
        super.onStop()
        weatherListPresenter.clearDisposables()
    }

    override fun onDestroy() {
        super.onDestroy()
        weatherListPresenter.detach()
        arguments?.clear()
    }

    override fun showEmptyView() {
        noWeatherText.visibility = View.VISIBLE
        weatherList.visibility = View.INVISIBLE
    }

    override fun showList() {
        noWeatherText.visibility = View.INVISIBLE
        weatherList.visibility = View.VISIBLE
    }

    override fun submitList(weatherList: List<CurrentWeather>) {
        weatherListAdapter.submitList(weatherList)
    }

    override fun showLoadingBar() {
        weatherListSwipeToRefresh.isRefreshing = true
    }

    override fun hideLoadingBar() {
        weatherListSwipeToRefresh.isRefreshing = false
    }

    override fun locationAdded() {
        Toast.makeText(context, "Location added", Toast.LENGTH_SHORT).show()
    }

    override fun listTooLong() {
        Toast.makeText(context, "Unable to add location", Toast.LENGTH_SHORT).show()
    }

    override fun listUpdated() {
        Toast.makeText(context, "List updated", Toast.LENGTH_SHORT).show()
    }

    companion object {
        private val LAT_KEY = "LAT"
        private val LONG_KEY = "LONG"

        fun create(latitude: Double, longitude: Double): WeatherListFragment =
            WeatherListFragment().apply {
                arguments = Bundle().apply {
                    putDouble(LAT_KEY, latitude)
                    putDouble(LONG_KEY, longitude)
                }
            }
    }
}