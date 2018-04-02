package com.nicholasdoglio.weather.ui.list

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil.ItemCallback
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nicholasdoglio.weather.R
import com.nicholasdoglio.weather.data.model.WeatherResponse
import kotlinx.android.synthetic.main.item_list.view.*

class WeatherListAdapter :
    ListAdapter<WeatherResponse, WeatherListAdapter.WeatherListViewHolder>(diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return WeatherListViewHolder(inflater.inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: WeatherListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class WeatherListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(weatherResponse: WeatherResponse) {
            itemView.locationName.text = weatherResponse.name
            itemView.weatherDescription.text = weatherResponse.weather[0].description
            itemView.highTemp.text = weatherResponse.currentMain.tempMax.toString()
            itemView.lowTemp.text = weatherResponse.currentMain.tempMin.toString()
            itemView.weatherPhoto.setImageResource(R.mipmap.ic_launcher)
            //TODO set up image
        }
    }

    companion object {
        private val diff = object : ItemCallback<WeatherResponse>() {
            override fun areItemsTheSame(
                oldItem: WeatherResponse,
                newItem: WeatherResponse
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: WeatherResponse,
                newItem: WeatherResponse
            ): Boolean = oldItem == newItem
        }
    }
}