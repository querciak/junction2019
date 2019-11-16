package com.example.junction2019.view

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.junction2019.R
import com.example.junction2019.presenter.ShoppinglistPresenter
import kotlinx.android.synthetic.main.activity_main.*

class ShoppingListActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shoppinglist_layout)

        var presenter: ShoppinglistPresenter? = ShoppinglistPresenter(_activity = this)
        presenter!!.test()

    }


}