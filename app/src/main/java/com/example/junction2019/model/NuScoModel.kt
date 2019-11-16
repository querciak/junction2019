package com.example.junction2019.model

import android.util.Log
import java.net.HttpURLConnection
import java.net.URL

class NuScoModel {
    // http://127.0.0.1:5000/autocomplete/mait

    companion object {
        // constants
        val _URL = "http://127.0.0.1:5000/"
        val _REQUEST = "autocomplete/"

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
            /*
            val url = URL(_URL+ _REQUEST+queryProduct)


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

            val getURL : String = _URL + _REQUEST + queryProduct
            Log.d("REQUEST",getURL)

            var returnedString = URL(getURL).readText()
            
            // returning dummy data for now
            return convertProductsQueryToArray(returnedString)
        }

        private fun convertProductsQueryToArray(answer :String) : Array<Products> {
            return dummyQuery
        }


    }

}