package com.example.junction2019.view

import android.content.Context
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.junction2019.R
import com.example.junction2019.presenter.ShoppinglistPresenter
import kotlinx.android.synthetic.main.activity_main.*

class ShoppingListActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shoppinglist_layout)

        //var presenter: ShoppinglistPresenter? = ShoppinglistPresenter(_activity = this)
        val list = findViewById<ListView>(R.id.productList)
        //presenter!!.test()

        var products = arrayOf("product 1", "product 2", "product 3", "product 4", "product 5", "product 6", "product 7", "product 8", "product 9")

        list.adapter = MyCustomAdapter(this, products)





    }

    private class MyCustomAdapter(context: Context, list: Array<String>): BaseAdapter(){

        private val mycontext: Context
        private val myList: Array<String>

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
                rowMain.findViewById<ImageView>(R.id.imageView2)
            }
            rowMain.findViewById<TextView>(R.id.product).text = myList[position]
            return rowMain

        }
    }


}