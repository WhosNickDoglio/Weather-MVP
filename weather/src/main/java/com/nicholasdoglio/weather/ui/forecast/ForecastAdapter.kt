package com.nicholasdoglio.weather.ui.forecast

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nicholasdoglio.weather.R
import com.nicholasdoglio.weather.data.model.Forecast

/**
 * @author Nicholas Doglio
 */
class ForecastAdapter() :
    ListAdapter<Forecast, ForecastAdapter.ForecastViewHolder>(forecastDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ForecastViewHolder(inflater.inflate(R.layout.item_forecast_list, parent, false))
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(forecast: Forecast) {

        }
    }

    companion object {
        private val forecastDiff = object : DiffUtil.ItemCallback<Forecast>() {
            override fun areItemsTheSame(
                oldItem: Forecast?,
                newItem: Forecast?
            ): Boolean {
                return oldItem?.id == newItem?.id
            }

            override fun areContentsTheSame(
                oldItem: Forecast?,
                newItem: Forecast?
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}