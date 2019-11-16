package com.example.junction2019.presenter

import android.app.Activity
import android.graphics.Color
import android.view.View
import android.widget.TextView
import com.example.junction2019.R
import com.example.junction2019.model.NuScoModel
import com.example.junction2019.model.Parameters
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.model.SliceValue
import lecho.lib.hellocharts.view.PieChartView

@Suppress("DEPRECATION")
class NutriHistoryActivityPresenter(_activity: Activity) {

    private var activity: Activity = _activity

    fun initPieChart() {
        // init chart info
        val nutriScoreChart = activity.findViewById<PieChartView>(R.id.nutri_pie_chart)
        var nutriScoreData = mutableListOf<SliceValue>()

        // parse nusco history data from model
        var nusco_score = NuScoModel.parseNuScoHistoryData()

        // init piechart slices with parsed data
        nutriScoreData.add(SliceValue(nusco_score[Parameters.NUTRI_A], activity.getResources().getColor(R.color.nuscoA)))
        nutriScoreData.add(SliceValue(nusco_score[Parameters.NUTRI_B], activity.getResources().getColor(R.color.nuscoB)))
        nutriScoreData.add(SliceValue(nusco_score[Parameters.NUTRI_C], activity.getResources().getColor(R.color.nuscoC)))
        nutriScoreData.add(SliceValue(nusco_score[Parameters.NUTRI_D], activity.getResources().getColor(R.color.nuscoD)))
        nutriScoreData.add(SliceValue(nusco_score[Parameters.NUTRI_E], activity.getResources().getColor(R.color.nuscoE)))

        // assign the chart data
        var pieChartData = PieChartData(nutriScoreData)

        pieChartData.setHasCenterCircle(true).setCenterCircleScale(Parameters.INNER_CIRCLE_RATIO).setCenterCircleColor(activity.getResources().getColor(
            R.color.background_gray))

        nutriScoreChart.setPieChartData(pieChartData)

        nutriScoreChart.setChartRotation(210,false)
    }



    fun updatePieChart() {

    }

    fun initNuScoreText() {
        // init text element
        val nuScoText = activity.findViewById<TextView>(R.id.nutriScoreLabel)

        // parse data from back-end
        val nuScore : Char = NuScoModel.getNuScoAverage()

        var colorOfScore : Int = activity.getResources().getColor(R.color.nuscoE)
        // update text based on return
        when (nuScore){
            'A' -> colorOfScore = activity.getResources().getColor(R.color.nuscoA)
            'B' -> colorOfScore = activity.getResources().getColor(R.color.nuscoB)
            'C' -> colorOfScore = activity.getResources().getColor(R.color.nuscoC)
            'D' -> colorOfScore = activity.getResources().getColor(R.color.nuscoD)
            else -> colorOfScore = activity.getResources().getColor(R.color.nuscoE)
        }
        nuScoText.text = nuScore.toString()
        nuScoText.setTextColor(colorOfScore)
    }


}
