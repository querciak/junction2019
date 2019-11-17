package com.example.junction2019.view

import android.app.slice.Slice
import android.graphics.Color
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.junction2019.R
import com.example.junction2019.model.NuScoModel
import com.example.junction2019.model.Parameters
import com.example.junction2019.presenter.NutriHistoryActivityPresenter
import kotlinx.android.synthetic.main.nutri_history.*
import lecho.lib.hellocharts.listener.PieChartOnValueSelectListener
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
        presenter.initNuScoreText()

        // event handlers
        nutri_pie_chart.onValueTouchListener = ValueTouchListener(this,presenter)
        btn_weekly.setOnClickListener(HandleGrouppedButtons(this,presenter))
        btn_monthly.setOnClickListener(HandleGrouppedButtons(this,presenter))
        btn_yearly.setOnClickListener(HandleGrouppedButtons(this,presenter))
        nutriScoreLabel.setOnClickListener(View.OnClickListener {
            presenter.guiHandleExtendedView()
        })

    }

    private class ValueTouchListener : PieChartOnValueSelectListener{

        val activity : AppCompatActivity
        val presenter : NutriHistoryActivityPresenter

        constructor(_activity : AppCompatActivity, _presenter : NutriHistoryActivityPresenter){
            activity = _activity
            presenter = _presenter
        }

        override fun onValueSelected(arcIndex: Int, value: SliceValue?) {
            Log.d("TAG","arc index is $arcIndex with a value of $value")
            /*
            var nusco_score = NuScoModel.getNuScoAverage()
            when (arcIndex) {
                Parameters.NUTRI_A -> nusco_score = Parameters.NUTRI_A_CHAR
                Parameters.NUTRI_B -> nusco_score = Parameters.NUTRI_B_CHAR
                Parameters.NUTRI_C -> nusco_score = Parameters.NUTRI_C_CHAR
                Parameters.NUTRI_D -> nusco_score = Parameters.NUTRI_D_CHAR
                else -> nusco_score = Parameters.NUTRI_E_CHAR
            }
            presenter.initNuScoreText()
            */
        }

        override fun onValueDeselected() {
            TODO("not implemented -> not relevant for the moment") //To change body of created functions use File | Settings | File Templates.
        }
    }

    private class HandleGrouppedButtons : View.OnClickListener{
        val activity : AppCompatActivity
        val presenter : NutriHistoryActivityPresenter

        constructor(_activity : AppCompatActivity, _presenter : NutriHistoryActivityPresenter){
            activity = _activity
            presenter = _presenter
        }

        override fun onClick(btn: View?) {
            presenter.guiHandleGrouppedButtons(btn)
        }

    }

}
