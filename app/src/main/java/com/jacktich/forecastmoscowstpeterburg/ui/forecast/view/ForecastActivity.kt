package com.jacktich.forecastmoscowstpeterburg.ui.forecast.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jacktich.forecastmoscowstpeterburg.R
import com.jacktich.forecastmoscowstpeterburg.ui.base.view.BaseActivity

class ForecastActivity : BaseActivity(), ForecastMVPView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showMessage(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}