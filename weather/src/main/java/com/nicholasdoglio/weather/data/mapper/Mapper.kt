package com.nicholasdoglio.weather.data.mapper

interface Mapper<T, V> {

  fun mapFromResponse(response: T): V

}