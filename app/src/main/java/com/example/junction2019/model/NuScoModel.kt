package com.example.junction2019.model

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.junction2019.view.ShoppingListActivity
import java.net.HttpURLConnection
import java.net.URL

class NuScoModel {
    // http://127.0.0.1:5000/autocomplete/mait

    companion object {
        // constants
        val _URL = "http://127.0.0.1:5000/"
        val _REQUEST = "autocomplete/"

        // shit
        var activity : AppCompatActivity? = null

        // DUMMY RESPONSES
        var nuScoRatios = listOf<Float>(0.2f, 0.3f, 0.1f, 0.3f, 0.1f)
        var nuSco : Char = 'D'
        var dummyQuery = arrayOf(Products("danone yoghurt"), Products("oatly yoghurt"))

        fun parseNuScoHistoryData(): List<Float> {
            //TODO request data from back-end

            // returning dummy data for now
            return nuScoRatios
        }

        fun getNuScoAverage(): Char {
            //TODO request data from back-end

            // returning dummy data for now
            return nuSco
        }

        fun queryProductsByKeyWord(queryProduct: String): Array<Products> {
            //TODO request data from back-end

            //val construct_url = URL(_URL+ _REQUEST+queryProduct)
            /*

            var returnedString = ""

            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET"  // optional default is GET

                //println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

                inputStream.bufferedReader().use {
                    it.lines().forEach { line ->
                        Log.d("QUERY_ANSWER", line)
                        returnedString += line
                    }
                }
            }
            */

            var returnedString = ""//URL("https://kesko.azure-api.net/products/N106/6408430001323").readText()


            val queue = Volley.newRequestQueue(activity)
            //val url = getURL
            val url = "https://kesko.azure-api.net/products/N106/6408430001323"

            // Request a string response from the provided URL.
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> { response ->
                    // Display the first 500 characters of the response string.
                    //textView.text = "Response is: ${response.substring(0, 500)}"
                    returnedString = response.substring(0,500)
                    Log.d("RIGHT_DICK",returnedString)
                },
                Response.ErrorListener {
                    returnedString = "That didn't work!"
                    Log.d("DICK","That didn't work!")
                })

            // Add the request to the RequestQueue.
            queue.add(stringRequest)



            /*
            var returnedString : String = ""

            var url = URL("https://kesko.azure-api.net/products/N106/6408430001323")

            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET"  // optional default is GET

                println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

                inputStream.bufferedReader().use {
                    it.lines().forEach { line ->
                        returnedString += line
                    }
                }
            }*/
            
            // returning dummy data for now
            return convertProductsQueryToArray(returnedString)
        }

        private fun convertProductsQueryToArray(answer :String) : Array<Products> {
            return dummyQuery
        }

    }

}