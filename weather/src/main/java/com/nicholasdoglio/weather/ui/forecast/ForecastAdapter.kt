package com.nicholasdoglio.weather.ui.forecast

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.nicholasdoglio.weather.R
import com.nicholasdoglio.weather.data.model.Forecast

/**
 * @author Nicholas Doglio
 */
class ForecastAdapter : ListAdapter<Forecast, ForecastAdapter.ForecastViewHolder>(forecastDiff) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    return ForecastViewHolder(inflater.inflate(R.layout.item_forecast_list, parent, false))
  }

  override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
    holder.bind(getItem(position))
  }

  inner class ForecastViewHolder(itemView: View) :
    androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

    fun bind(forecast: Forecast) {

    }
  }

  companion object {
    private val forecastDiff = object : DiffUtil.ItemCallback<Forecast>() {
      override fun areItemsTheSame(
        oldItem: Forecast,
        newItem: Forecast
      ): Boolean = oldItem.id == newItem.id

      override fun areContentsTheSame(
        oldItem: Forecast,
        newItem: Forecast
      ): Boolean = oldItem == newItem
    }
  }
}