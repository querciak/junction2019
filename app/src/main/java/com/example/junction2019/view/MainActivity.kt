package com.example.junction2019.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.os.StrictMode



class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.junction2019.R.layout.activity_main)

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
