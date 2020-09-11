package com.jacktich.forecastmoscowstpeterburg.ui.forecast.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jacktich.forecastmoscowstpeterburg.R
import com.jacktich.forecastmoscowstpeterburg.data.responces.DataDayWeather
import com.jacktich.forecastmoscowstpeterburg.utils.getImageFromApi
import com.jacktich.forecastmoscowstpeterburg.utils.getTempString
import com.jacktich.forecastmoscowstpeterburg.utils.localDateFromEpoch
import com.jacktich.forecastmoscowstpeterburg.utils.toDegrees

import org.threeten.bp.format.DateTimeFormatter

class WeatherAdapter(val callback: OnClickWeatherItem) :
    androidx.recyclerview.widget.ListAdapter<DataDayWeather, RecyclerView.ViewHolder>(
        GenericDiffUtils<DataDayWeather>()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        WeatherViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_daily_weather, parent, false)
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as WeatherViewHolder).bindWeatherViewHolder(getItem(position))

    inner class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        val imgDayWeather = itemView.findViewById<ImageView>(R.id.imgDayWeather)
        val tvDegreesItmDay = itemView.findViewById<TextView>(R.id.tvDegreesItmDay)
        val tvDateItemDay = itemView.findViewById<TextView>(R.id.tvDateItemDay)

        fun bindWeatherViewHolder(day: DataDayWeather) {
            itemView.setOnClickListener(this)
            val averageDegrees = toDegrees((day.apparentTemperatureMin + day.apparentTemperatureMax) / 2)
            day.icon?.let {
                imgDayWeather.setImageResource(getImageFromApi(it))
            }
            tvDegreesItmDay.text = getTempString(averageDegrees, itemView.context)
            tvDateItemDay.text =
                localDateFromEpoch(day.time).format(DateTimeFormatter.ofPattern("EE,dd MMM"))
        }

        override fun onClick(v: View?) {
            callback.clickWeatherItem(position = absoluteAdapterPosition)
        }

    }

    interface OnClickWeatherItem {
        fun clickWeatherItem(position: Int)
    }
}
