package com.example.junction2019.view

import android.app.slice.Slice
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.junction2019.R
import com.example.junction2019.presenter.NutriHistoryActivityPresenter
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.model.SliceValue
import lecho.lib.hellocharts.view.PieChartView


@Suppress("DEPRECATION")
class NutriHistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nutri_history)

        // initiate presenter
        val presenter = NutriHistoryActivityPresenter(_activity = this)

        // init view elements which require data parsing
        presenter.initPieChart()


        // event handlers
        val pieChartView = findViewById<PieChartView>(R.id.nutri_pie_chart)
        //pieChartView.set


    }

}