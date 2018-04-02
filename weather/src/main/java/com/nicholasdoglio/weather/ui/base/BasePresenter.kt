package com.nicholasdoglio.weather.ui.base


/**
 * @author Nicholas Doglio
 */
interface BasePresenter<T> {

    fun attach(view: T)

    fun detach()

    fun clearDisposables()
}