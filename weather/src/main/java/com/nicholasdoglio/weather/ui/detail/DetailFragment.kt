package com.nicholasdoglio.weather.ui.detail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nicholasdoglio.weather.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_detail.*
import javax.inject.Inject


class DetailFragment : DaggerFragment(), DetailContract.View {

    //TODO look into weather icons from material design icons

    @Inject
    lateinit var detailPresenter: DetailContract.Presenter

    override fun showLoadingBar() {
        detailProgressBar.show()
    }

    override fun hideLoadingBar() {
        detailProgressBar.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        detailPresenter.attach(this)
    }

    override fun onStop() {
        super.onStop()
        detailPresenter.clearDisposables()
    }

    override fun onDestroy() {
        super.onDestroy()
        detailPresenter.detach()
    }
}
