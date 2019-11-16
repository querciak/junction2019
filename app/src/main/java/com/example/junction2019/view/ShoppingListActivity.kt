package com.example.junction2019.view

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.Layout
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.junction2019.R
import com.example.junction2019.model.NuScoModel
import com.example.junction2019.model.Products
import com.example.junction2019.presenter.ShoppinglistPresenter
import kotlinx.android.synthetic.main.activity_main.*
import java.security.AccessController.getContext

class ShoppingListActivity: AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shoppinglist_layout)



        //arrayOf(Products("cereal 1"), Products("cereal 2"), Products("cereal 3"))
        var yogurt = arrayOf(Products("yogurt x"), Products("yogurt y"), Products("yogurt z"))
        val list = findViewById<ListView>(R.id.productList)
        val productToRetrieve = findViewById<TextView>(R.id.search)
        val search = findViewById<ImageView>(R.id.imageView6)

        search.setOnClickListener{
            // get the query text from the edit box
            var queryProduct = productToRetrieve.text.toString()

            // query data from model
            var queriedProducts = NuScoModel.queryProductsByKeyWord(queryProduct)
            list.adapter = MyCustomAdapter(this,queriedProducts)

        }








    }

    /*fun showProducts(){
        if (productToRetrieve.text == "cereal") {
            list.adapter = MyCustomAdapter(this, cereal)
        }else if(productToRetrieve.text == "yogurt"){
            list.adapter = MyCustomAdapter(this, yogurt)
        }
    }

     */

    private class MyCustomAdapter(context: Context, list: Array<Products>): BaseAdapter(){

        private val mycontext: Context
        private val myList: Array<Products>

        init {
            mycontext = context
            myList = list
        }
        override fun getCount(): Int {
            return myList.size
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return "test string"
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mycontext)
            val rowMain = layoutInflater.inflate(R.layout.listview_items, parent, false)
            if(position == 0){
                val dot = rowMain.findViewById<ImageView>(R.id.imageView2)
                dot.setColorFilter(ContextCompat.getColor(mycontext, R.color.dot), android.graphics.PorterDuff.Mode.MULTIPLY)
            }
            rowMain.findViewById<TextView>(R.id.product).text = myList[position].name
            return rowMain

        }
    }


}