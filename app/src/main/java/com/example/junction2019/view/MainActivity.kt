package com.example.junction2019.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.junction2019.R
import com.example.junction2019.presenter.MainActivityPresenter

class MainActivity : AppCompatActivity() {

    private var presenter: MainActivityPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


}
