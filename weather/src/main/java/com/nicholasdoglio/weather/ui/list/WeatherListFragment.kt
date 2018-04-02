package com.nicholasdoglio.weather.ui.list


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nicholasdoglio.weather.R
import com.nicholasdoglio.weather.data.model.WeatherResponse
import com.nicholasdoglio.weather.ui.common.NavigationController
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_weather_list.*
import javax.inject.Inject

class WeatherListFragment : DaggerFragment(), WeatherListContract.View {

    @Inject
    lateinit var navigationController: NavigationController

    @Inject
    lateinit var weatherListPresenter: WeatherListContract.Presenter

    private lateinit var weatherListAdapter: WeatherListAdapter


    override fun showEmptyView() {
        noWeatherText.visibility = View.VISIBLE
        weatherList.visibility = View.INVISIBLE
    }

    override fun updateWeatherList(weatherList: List<WeatherResponse>) {
        weatherListAdapter.submitList(weatherList)
    }

    override fun showLoadingBar() {
        listProgressBar.show()
    }

    override fun hideLoadingBar() {
        listProgressBar.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        weatherListAdapter = WeatherListAdapter()

        weatherList.apply {
            adapter = weatherListAdapter
            layoutManager = LinearLayoutManager(context)
        }

        weatherListPresenter.refreshWeatherListLocations()

        seachFab.setOnClickListener { navigationController.openSearch() }
    }

    override fun onStart() {
        super.onStart()
        weatherListPresenter.attach(this)
    }

    override fun onStop() {
        super.onStop()
        weatherListPresenter.clearDisposables()
    }

    override fun onDestroy() {
        super.onDestroy()
        weatherListPresenter.detach()
    }
}