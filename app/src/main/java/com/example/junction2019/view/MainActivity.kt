package com.example.junction2019.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.junction2019.R
import com.example.junction2019.presenter.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // click listener for nusco history button
        nutritionButton.setOnClickListener {
            val intent = Intent(this, NutriHistoryActivity::class.java)
            startActivity(intent)
        }
        shoppinglistButton.setOnClickListener {
            val intent = Intent(this, ShoppingListActivity::class.java)
            startActivity(intent)
        }
    }

}
