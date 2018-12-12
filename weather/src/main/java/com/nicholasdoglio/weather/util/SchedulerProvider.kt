package com.nicholasdoglio.weather.util

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object SchedulerProvider : Provider {

  override fun main(): Scheduler = AndroidSchedulers.mainThread()

  override fun io(): Scheduler = Schedulers.io()
}