package com.example.junction2019.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.junction2019.R
import com.example.junction2019.presenter.NutriHistoryActivityPresenter


class NutriHistoryActivity : AppCompatActivity() {

    init {
        var presenter: NutriHistoryActivityPresenter? = NutriHistoryActivityPresenter(_activity = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nutri_history)
    }

}