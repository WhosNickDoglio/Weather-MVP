package com.nicholasdoglio.weather.ui.list

import com.nicholasdoglio.weather.data.model.CurrentWeather
import com.nicholasdoglio.weather.data.repo.WeatherRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author Nicholas Doglio
 */
class WeatherListPresenter @Inject constructor(private val weatherRepository: WeatherRepository) :
  WeatherListContract.Presenter {

  private var weatherListView: WeatherListContract.View? = null
  private val compositeDisposable = CompositeDisposable()

  override fun attach(view: WeatherListContract.View) {
    this.weatherListView = view
  }

  override fun detach() {
    weatherListView = null
  }

  override fun clearDisposables() {
    compositeDisposable.clear()
  }

  override fun addLocationToList(lat: Double, long: Double) {
    weatherListView?.showLoadingBar()
    compositeDisposable += weatherRepository.addLocation(lat, long)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({ handleLocationAdded() }, { handleError(it) })
  }

  override fun refreshWeatherListLocations() {
    weatherListView?.showLoadingBar()
    compositeDisposable += weatherRepository.updateWeatherList()
      .subscribeOn(Schedulers.io())
      .subscribe({ handleRefreshListSuccess() }, { handleError(it) })
  }

  override fun observeNumberOfLocations() {
    compositeDisposable += weatherRepository.observeNumberOfLocations()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({ handleNumberOfLocations(it) }, { it.printStackTrace() })
  }

  override fun observeWeatherList() {
    weatherListView?.showLoadingBar()
    compositeDisposable += weatherRepository.observeWeatherLocations()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({ handleGetWeatherInformationSuccess(it) }, { handleError(it) })
  }

  private fun handleLocationAdded() {
    weatherListView?.hideLoadingBar()
    weatherListView?.listUpdated()
  }

  private fun handleRefreshListSuccess() {
    weatherListView?.hideLoadingBar()
    weatherListView?.listUpdated()
  }

  private fun handleAddLocationSuccess(currentWeather: CurrentWeather) {
    weatherListView?.hideLoadingBar()
  }

  private fun handleNumberOfLocations(numOfLocations: Int) {
    when (numOfLocations > 0) {
      true -> weatherListView?.showList()
      false -> weatherListView?.showEmptyView()
    }
  }

  //TODO I need to connect this to Room
  private fun handleGetWeatherInformationSuccess(currentWeather: List<CurrentWeather>) {
    weatherListView?.hideLoadingBar()
    when (currentWeather.isEmpty()) {
      true -> weatherListView?.showEmptyView()
      false -> weatherListView?.submitList(currentWeather)
    }
  }

  private fun handleError(error: Throwable) {
    weatherListView?.hideLoadingBar()
    error.printStackTrace()
  }
}