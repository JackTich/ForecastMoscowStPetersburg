package com.jacktich.forecastmoscowstpeterburg.data.responces

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetWeatherResponse(
    @Expose
    @SerializedName("latitude")
    internal val latitude: Double,
    @Expose
    @SerializedName("longitude")
    internal val longitude: Double,
    @Expose
    @SerializedName("timezone")
    internal val timezone: String?,
    @Expose
    @SerializedName("currently")
    internal val currently: DataCurrentlyDayWeather,
    @Expose
    @SerializedName("daily")
    internal val daily: DataMainDailyWeather,

)

data class DataCurrentlyDayWeather(
    @Expose
    @SerializedName("time")
    internal val time: Long,
    @Expose
    @SerializedName("icon")
    internal val icon: String?,
    @Expose
    @SerializedName("summary")
    internal val summary: String,
    @Expose
    @SerializedName("temperature")
    internal val temperature: Double
)

data class DataMainDailyWeather(
    @Expose
    @SerializedName("summary")
    internal val summary: String,
    @Expose
    @SerializedName("icon")
    internal val icon: String?,
    @Expose
    @SerializedName("data")
    internal val data: List<DataDayWeather>
)


data class DataDayWeather(
    @Expose
    @SerializedName("summary")
    internal val summary: String,
    @Expose
    @SerializedName("time")
    internal val time: Long,
    @Expose
    @SerializedName("icon")
    internal val icon: String?,
    @Expose
    @SerializedName("apparentTemperatureMin")
    internal val apparentTemperatureMin: Double,
    @Expose
    @SerializedName("apparentTemperatureMax")
    internal val apparentTemperatureMax: Double
)