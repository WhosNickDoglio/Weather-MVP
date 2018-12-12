package com.nicholasdoglio.weather.util

import io.reactivex.Scheduler

interface Provider {

  fun main(): Scheduler

  fun io(): Scheduler
}