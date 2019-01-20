/*
 * MIT License
 *
 * Copyright (c) 2019 Nicholas Doglio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.nicholasdoglio.weather.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nicholasdoglio.weather.R
import com.nicholasdoglio.weather.data.model.CurrentWeather
import com.nicholasdoglio.weather.ui.common.NavigationController

/**
 * @author Nicholas Doglio
 */
class WeatherListAdapter(private val navigationController: NavigationController) :
    ListAdapter<CurrentWeather, WeatherListAdapter.WeatherListViewHolder>(diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return WeatherListViewHolder(inflater.inflate(R.layout.item_weather_list, parent, false))
    }

    override fun onBindViewHolder(holder: WeatherListViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            navigationController.openForecastFragment(getItem(position).id)
        }
    }

    inner class WeatherListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    LayoutContainer
//
//    override val containerView: View?
//      get() = itemView

        fun bind(currentWeather: CurrentWeather) {
//      locationName.text = currentWeather.locationName
//      currentTemp.text = Math.round(currentWeather.currentTemp).toString()
//            itemView.weatherPhoto TODO fix this
        }
    }

    companion object {
        private val diff = object : ItemCallback<CurrentWeather>() {
            override fun areItemsTheSame(
                oldItem: CurrentWeather,
                newItem: CurrentWeather
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: CurrentWeather,
                newItem: CurrentWeather
            ): Boolean = oldItem == newItem
        }
    }
}