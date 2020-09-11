package com.jacktich.forecastmoscowstpeterburg.data.models

import android.os.Parcel
import android.os.Parcelable

data class ModelCoords (
    internal val latitude: Double,
    internal val longitude: Double
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(latitude)
        parcel.writeDouble(longitude)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ModelCoords> {
        override fun createFromParcel(parcel: Parcel): ModelCoords {
            return ModelCoords(parcel)
        }

        override fun newArray(size: Int): Array<ModelCoords?> {
            return arrayOfNulls(size)
        }
    }

}