package com.nicholasdoglio.weather.ui.search


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nicholasdoglio.weather.R
import com.nicholasdoglio.weather.ui.common.NavigationController
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SearchFragment : DaggerFragment(), SearchContract.View {

    @Inject
    lateinit var navigationController: NavigationController

    @Inject
    lateinit var searchPresenter: SearchContract.Presenter

    override fun showLoadingBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoadingBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        searchPresenter.attach(this)
    }

    override fun onStop() {
        super.onStop()
        searchPresenter.clearDisposables()
    }

    override fun onDestroy() {
        super.onDestroy()
        searchPresenter.detach()
    }
}
