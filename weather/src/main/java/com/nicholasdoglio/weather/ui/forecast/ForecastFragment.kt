package com.nicholasdoglio.weather.ui.forecast


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nicholasdoglio.weather.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_forecast.*
import javax.inject.Inject

/**
 * @author Nicholas Doglio
 */
class ForecastFragment : DaggerFragment(), ForecastContract.View {

    //TODO look into weather icons from material design icons

    @Inject
    lateinit var forecastPresenter: ForecastContract.Presenter

    override fun showLoadingBar() {
        detailSwipeToRefresh.isRefreshing = true
    }

    override fun hideLoadingBar() {
        detailSwipeToRefresh.isRefreshing = false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forecast, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        forecastPresenter.attach(this)
    }

    override fun onStop() {
        super.onStop()
        forecastPresenter.clearDisposables()
    }

    override fun onDestroy() {
        super.onDestroy()
        forecastPresenter.detach()
    }

    companion object {
        fun create(id: Int): ForecastFragment {
            val weatherListFragment = ForecastFragment()
            val arguments = Bundle()
            arguments.putInt("FORECAST_ID", id)
            weatherListFragment.arguments = arguments
            return weatherListFragment
        }
    }
}
