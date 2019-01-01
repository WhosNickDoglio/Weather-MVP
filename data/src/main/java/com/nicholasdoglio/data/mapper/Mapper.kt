package com.nicholasdoglio.data.data.mapper

interface Mapper<T, V> {

  fun mapFromResponse(response: T): V

}