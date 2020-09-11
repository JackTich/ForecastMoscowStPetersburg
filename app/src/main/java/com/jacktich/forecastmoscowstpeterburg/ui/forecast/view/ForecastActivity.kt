package com.jacktich.forecastmoscowstpeterburg.ui.forecast.view

import android.content.Intent
import android.graphics.Typeface
import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jacktich.forecastmoscowstpeterburg.R
import com.jacktich.forecastmoscowstpeterburg.data.responces.DataCurrentlyDayWeather
import com.jacktich.forecastmoscowstpeterburg.data.responces.DataDayWeather
import com.jacktich.forecastmoscowstpeterburg.data.responces.DataMainDailyWeather
import com.jacktich.forecastmoscowstpeterburg.ui.base.view.BaseActivity
import com.jacktich.forecastmoscowstpeterburg.ui.forecast.adapters.WeatherAdapter
import com.jacktich.forecastmoscowstpeterburg.ui.forecast.interactor.ForecastMVPInteractor
import com.jacktich.forecastmoscowstpeterburg.ui.forecast.presenter.ForecastPresenter
import com.jacktich.forecastmoscowstpeterburg.ui.gmap.view.GmapActivity
import com.jacktich.forecastmoscowstpeterburg.utils.*
import kotlinx.android.synthetic.main.activity_forecast.*
import org.threeten.bp.LocalDateTime
import javax.inject.Inject

class ForecastActivity : BaseActivity(), ForecastMVPView {

    companion object {
        const val KEY_MOSCOW = 1
        const val KEY_ST_PETERSBURG = 2
        const val KEY_POSITION = "keyPosition"
    }

    @Inject
    internal lateinit var presenter: ForecastPresenter<ForecastMVPView, ForecastMVPInteractor>

    private val adapterList = WeatherAdapter(object : WeatherAdapter.OnClickWeatherItem {
        override fun clickWeatherItem(position: Int) {
            startGmapActivity(position)
        }
    })

    private fun startGmapActivity(position: Int) {
        val intent = Intent(this@ForecastActivity, GmapActivity::class.java)
        intent.putExtra(KEY_POSITION, position)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)
        presenter.onAttach(this)
        initAdapter()
        onClick()
        val groupKey = presenter.getPref().getCurrCity()
        if (localTimeFromEpoch(presenter.getPref().getCurrEpoch()) <= LocalDateTime.now()
                .minusHours(1)
        ) {
            presenter.initForecastActivity(groupKey)
            updateTabFromPref(groupKey)
        } else {
            with(presenter.getPref()) {
                updateTabFromPref(groupKey)
                refreshAdapter(this.getWeatherList())
                initHeader(this.getCurrWeather())
                setCoords(this.getCoords())
            }

        }
    }

    private fun initAdapter() {
        rvForecast.apply {
            adapter = adapterList
            layoutManager = LinearLayoutManager(this@ForecastActivity)
            addItemDecoration(DividerItemDecoration(this.context, ClipDrawable.HORIZONTAL))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

    private fun onClick() {
        groupMoscow.setOnClickListener {
            presenter.getPref().setCurrCity(KEY_MOSCOW)
            adapterList.submitList(null)
            resetHeader()
            resetTabs()
            updateMoscowTab()
            presenter.initForecastActivity(KEY_MOSCOW)
        }
        groupStPet.setOnClickListener {
            presenter.getPref().setCurrCity(KEY_ST_PETERSBURG)
            adapterList.submitList(null)
            resetHeader()
            resetTabs()
            updateStPetTab()
            presenter.initForecastActivity(KEY_ST_PETERSBURG)
        }
    }

    private fun resetHeader(){
        imgCurrWeather.setImageResource(0)
        tvCurrStateWeather.text = getString(R.string.three_dots)
        tvCurrentlyTemp.text = getString(R.string.three_dots)
    }

    private fun updateStPetTab() {
        lineStPet.makeVisible()
        textStPet.typeface = Typeface.DEFAULT_BOLD
    }

    private fun updateMoscowTab() {
        lineMoscow.makeVisible()
        textMoscow.typeface = Typeface.DEFAULT_BOLD
    }

    private fun updateTabFromPref(key: Int) {
        when (key) {
            KEY_MOSCOW -> updateMoscowTab()
            KEY_ST_PETERSBURG -> updateStPetTab()
        }
    }

    private fun resetTabs() {
        lineMoscow.makeGone()
        lineStPet.makeGone()
        textMoscow.typeface = Typeface.DEFAULT
        textStPet.typeface = Typeface.DEFAULT
    }

    override fun showMessage(message: String) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    override fun refreshAdapter(mainDailyWeather: DataMainDailyWeather) {
        adapterList.submitList(mainDailyWeather.data)
    }

    override fun initHeader(currentlyDayWeather: DataCurrentlyDayWeather) {
        val currDegrees = toDegrees(currentlyDayWeather.temperature)
        currentlyDayWeather.icon?.let {
            imgCurrWeather.setImageResource(getImageFromApi(it))
        }
        tvCurrStateWeather.text = currentlyDayWeather.summary
        tvCurrentlyTemp.text = getTempString(currDegrees, this)
    }

}