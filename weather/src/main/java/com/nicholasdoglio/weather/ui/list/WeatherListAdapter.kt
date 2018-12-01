package com.nicholasdoglio.weather.ui.list

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil.ItemCallback
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nicholasdoglio.weather.R
import com.nicholasdoglio.weather.data.model.CurrentWeather
import com.nicholasdoglio.weather.ui.common.NavigationController
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_weather_list.*

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
            navigationController.openForecastFragment(
                getItem(
                    position
                ).id
            )
        }
    }

    inner class WeatherListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        LayoutContainer {

        override val containerView: View?
            get() = itemView

        fun bind(currentWeather: CurrentWeather) {
            locationName.text = currentWeather.locationName
            currentTemp.text = Math.round(currentWeather.currentTemp).toString()
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