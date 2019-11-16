package com.example.junction2019.presenter

import android.app.Activity
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.junction2019.R

class ShoppinglistPresenter( _activity: Activity) {

    private var activity: Activity = _activity

    fun test(){
        var products = arrayOf("product 1", "product 2", "product 3", "product 4", "product 5", "product 6", "product 7", "product 8", "product 9")
        //var adapter = ArrayAdapter<String>(this, R.layout.shoppinglist_layout, products)
        val list = activity.findViewById<ListView>(R.id.productList)
    }

    // function to add element to user's basket
    fun addElement(){

    }

}

