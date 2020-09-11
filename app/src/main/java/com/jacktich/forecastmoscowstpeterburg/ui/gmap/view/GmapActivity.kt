package com.jacktich.forecastmoscowstpeterburg.ui.gmap.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.jacktich.forecastmoscowstpeterburg.R
import com.jacktich.forecastmoscowstpeterburg.ui.base.view.BaseActivity
import com.jacktich.forecastmoscowstpeterburg.ui.forecast.view.ForecastActivity
import com.jacktich.forecastmoscowstpeterburg.ui.gmap.interactor.GmapMVPInteractor
import com.jacktich.forecastmoscowstpeterburg.ui.gmap.presenter.GmapPresenter
import com.jacktich.forecastmoscowstpeterburg.utils.getImageFromApi
import com.jacktich.forecastmoscowstpeterburg.utils.getTempString
import com.jacktich.forecastmoscowstpeterburg.utils.toDegrees
import kotlinx.android.synthetic.main.activity_gmap.*
import javax.inject.Inject

class GmapActivity : BaseActivity(), OnMapReadyCallback, GmapMVPView {

    @Inject
    internal lateinit var presenter: GmapPresenter<GmapMVPView, GmapMVPInteractor>

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gmap)
        presenter.onAttach(this)
        initInfoWindow(intent.extras!!.getInt(ForecastActivity.KEY_POSITION))
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun initInfoWindow(position: Int){
        val currentDay = presenter.getPref().getWeatherList().data[position]
        val averageDegrees = toDegrees((currentDay.apparentTemperatureMin + currentDay.apparentTemperatureMax) / 2)
        currentDay.icon?.let{
            imgGmapWeather.setImageResource(getImageFromApi(it))
        }
        tvGmapTemperature.text = getTempString(averageDegrees, this)
        tvGmapWeatherState.text = currentDay.summary
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        val coords = presenter.getPref().getCoords()
        mMap = googleMap
        val location = LatLng(coords.latitude, coords.longitude)
        mMap.addMarker(MarkerOptions().position(location))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }
}