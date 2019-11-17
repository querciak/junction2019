package com.example.junction2019.presenter

import android.app.Activity
import android.graphics.Color
import android.os.AsyncTask
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.junction2019.R
import com.example.junction2019.model.NuScoModel
import com.example.junction2019.model.Parameters
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.model.SliceValue
import lecho.lib.hellocharts.view.PieChartView
import khttp.get

@Suppress("DEPRECATION")
class NutriHistoryActivityPresenter(_activity: Activity) {

    private var activity: Activity = _activity
    private var activeBtn : Int = Parameters.BUTTONS[Parameters.BTN_WEEK]
    private var extendedViewActive : Boolean = false
    val buttons = listOf<Button>(activity.findViewById(R.id.btn_weekly),activity.findViewById(R.id.btn_monthly),activity.findViewById(R.id.btn_yearly))

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
        val nuScore : String = NuScoModel.getNuScoAverage()

        var colorOfScore : Int = activity.getResources().getColor(R.color.nuscoE)
        // update text based on return
        when (nuScore){
            Parameters.NUTRI_A_CHAR -> colorOfScore = activity.getResources().getColor(R.color.nuscoA)
            Parameters.NUTRI_B_CHAR -> colorOfScore = activity.getResources().getColor(R.color.nuscoB)
            Parameters.NUTRI_C_CHAR -> colorOfScore = activity.getResources().getColor(R.color.nuscoC)
            Parameters.NUTRI_D_CHAR -> colorOfScore = activity.getResources().getColor(R.color.nuscoD)
            else -> colorOfScore = activity.getResources().getColor(R.color.nuscoE)
        }
        nuScoText.text = nuScore.toString()
        nuScoText.setTextColor(colorOfScore)
    }

    fun guiHandleGrouppedButtons(btn : View?) {
        if(btn?.id != null){
            val pressedButton = activity.findViewById<Button>(btn.id)
            Log.d("BUTTONTAG", "pressed button id is (${pressedButton.id})")

            // check whether the active button is the pressed one, if not update GUI
            if(buttons[activeBtn] == pressedButton){
                // do nothing right now
            }
            else{
                for(btn in buttons){
                    btn.setBackgroundColor(activity.getResources().getColor(R.color.btn_gray))
                }
                pressedButton.setBackgroundColor(activity.getResources().getColor(R.color.btn_orange))
                activeBtn = buttons.indexOf(pressedButton)
            }

        }
    }

    fun guiHandleExtendedView() {
        if (!extendedViewActive) {
            val hiddenlayout = activity.findViewById<ConstraintLayout>(R.id.extendedPanelNutriScore)
            hiddenlayout.setVisibility(View.VISIBLE)
            val hiddenlinearlayout = activity.findViewById<LinearLayout>(R.id.hiddenlinearlayout)
            hiddenlinearlayout.visibility = View.VISIBLE
        }
    }
}
