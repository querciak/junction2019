package com.example.junction2019.presenter

import android.app.Activity
import android.view.View
import com.example.junction2019.R
import com.example.junction2019.model.NuScoModel
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.model.SliceValue
import lecho.lib.hellocharts.view.PieChartView

@Suppress("DEPRECATION")
class NutriHistoryActivityPresenter(_activity: Activity) {

    val INNER_CIRCLE_RATIO : Float = 0.70f

    private var activity: Activity = _activity

    fun initPieChart() {
        // init chart info
        val nutriScoreChart = activity.findViewById<PieChartView>(R.id.nutri_pie_chart)
        var nutriScoreData = mutableListOf<SliceValue>()

        // parse nusco history data from model
        var nusco_score = NuScoModel.parseNuScoHistoryData()

        // init piechart slices with parsed data
        nutriScoreData.add(SliceValue(nusco_score[0], activity.getResources().getColor(R.color.nuscoA)))
        nutriScoreData.add(SliceValue(nusco_score[1], activity.getResources().getColor(R.color.nuscoB)))
        nutriScoreData.add(SliceValue(nusco_score[2], activity.getResources().getColor(R.color.nuscoC)))
        nutriScoreData.add(SliceValue(nusco_score[3], activity.getResources().getColor(R.color.nuscoD)))
        nutriScoreData.add(SliceValue(nusco_score[4], activity.getResources().getColor(R.color.nuscoE)))

        // assign the chart data
        var pieChartData = PieChartData(nutriScoreData)

        pieChartData.setHasCenterCircle(true).setCenterCircleScale(INNER_CIRCLE_RATIO).setCenterCircleColor(activity.getResources().getColor(
            R.color.background_gray))

        nutriScoreChart.setPieChartData(pieChartData)
    }

    fun updatePieChart() {

    }

    

}
