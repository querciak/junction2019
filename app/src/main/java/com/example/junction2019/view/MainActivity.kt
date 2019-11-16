package com.example.junction2019.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.junction2019.R
import com.example.junction2019.presenter.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var presenter: MainActivityPresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nutritionButton.setOnClickListener {
            val intent = Intent(this, NutriHistoryActivity::class.java)
                startActivity(intent)
        }


    }


    /*
    btnDownload.setOnClickListener(handler);

    View.OnClickListener handler = new View.OnClickListener(){

        public void onClick(View v) {

            if(v==btnDownload){
                // doStuff
                Intent intentMain = new Intent(CurrentActivity.this ,
                    SecondActivity.class);
                CurrentActivity.this.startActivity(intentMain);
                Log.i("Content "," Main layout ");
            }
        }
    }
    */


}
