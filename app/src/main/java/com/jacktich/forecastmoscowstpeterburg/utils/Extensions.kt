package com.jacktich.forecastmoscowstpeterburg.utils

import android.content.Context
import android.view.View
import com.jacktich.forecastmoscowstpeterburg.R
import org.threeten.bp.Instant
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId
import kotlin.math.roundToInt

fun View.makeGone() {
    visibility = View.GONE
}

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun toDegrees(degrees: Double): Int = ((degrees.roundToInt() -32) * 5/9)

fun getImageFromApi(image: String): Int{
    return when(image){
        "rain" -> {
            R.drawable.ic_rain
        }
        "partly-cloudy-day" -> {
            R.drawable.ic_cloud
        }
        "clear-day" -> {
            R.drawable.ic_sun
        }
        else -> {
            R.drawable.ic_sky
        }
    }
}

fun getTempString(currDegrees: Int, context: Context): String =
    when {
        currDegrees > 0 -> {
            "+$currDegrees${context.resources.getString(R.string.degree)}"
        }
        currDegrees < 0 -> {
            "-$currDegrees${context.resources.getString(R.string.degree)}"
        }
        else -> {
            "$currDegrees${context.resources.getString(R.string.degree)}"
        }
    }


fun localDateFromEpoch(epoch: Long): LocalDate = Instant.ofEpochSecond(epoch).atZone(ZoneId.systemDefault()).toLocalDate()

fun localTimeFromEpoch(epoch: Long): LocalDateTime = Instant.ofEpochSecond(epoch).atZone(ZoneId.systemDefault()).toLocalDateTime()