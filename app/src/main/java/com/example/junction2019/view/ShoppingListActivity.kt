package com.example.junction2019.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.junction2019.R
import com.example.junction2019.presenter.ShoppinglistPresenter

class ShoppingListActivity: AppCompatActivity() {

    init {
        var presenter: ShoppinglistPresenter? = ShoppinglistPresenter(_activity = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shoppinglist_layout)
    }
}