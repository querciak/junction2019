package com.example.junction2019.model

import android.icu.text.Bidi


import android.util.Log
import com.beust.klaxon.Klaxon
import com.example.junction2019.jsonmodels.*
import com.google.gson.Gson


class NuScoModel {
    // http://127.0.0.1:5000/autocomplete/mait

    companion object {
        var NUSCORE_DEFAULT_VALUE = listOf<Float>(0.2f, 0.3f, 0.1f, 0.3f, 0.1f)
        var PROFILE_DEFAULT_VALUE: String = "D"

        fun parseNuScoHistoryData(timespan : Int): List<Float> {
            //TODO request data from back-end

            // returning dummy data for now
            when(timespan){
                0 -> return convertNuScoHistoryQueryData(NuScoModelTest.QUERY_HISTORY_WEEK)
                1 -> return convertNuScoHistoryQueryData(NuScoModelTest.QUERY_HISTORY_MONTH)
                2 -> return convertNuScoHistoryQueryData(NuScoModelTest.QUERY_HISTORY_YEAR)
                else -> return emptyList()
            }
        }

        fun convertNuScoHistoryQueryData(queryString :String) : List<Float> {

            var gson = Gson()

            var data = gson.fromJson(queryString, NutriScoreHistory::class.java)
            Log.d("DATA", data.toString())

            /*
            val historyResult = Klaxon()
                .parse<History>(queryString)
            if(historyResult == null) {
                return NUSCORE_DEFAULT_VALUE
            }
            val nutriScoreResult = Klaxon()
                .parse<NutriScore>(historyResult.history)
            if(nutriScoreResult == null){
                return NUSCORE_DEFAULT_VALUE
            }
            val scores = Klaxon()
                .parse<ScoresInHistory>(nutriScoreResult.nutriScoreHist)
            if (scores == null)
            {
                return NUSCORE_DEFAULT_VALUE
            }
            return listOf(scores.scoreA,scores.scoreB,scores.scoreC,scores.scoreD,scores.scoreE)
             */

            return listOf(data.history!!.nutritionDist!!.A!!.toFloat(),data.history!!.nutritionDist!!.B!!.toFloat(),data!!.history!!.nutritionDist!!.C!!.toFloat(),data!!.history!!.nutritionDist!!.D!!.toFloat(),data!!.history!!.nutritionDist!!.E!!.toFloat())
        }

        fun getNuScoAverage(timespan: Int): String {
            // TODO connect to back-end

            // returning dummy data
            when(timespan){
                0 -> return convertNuScoAverage(NuScoModelTest.QUERY_HISTORY_WEEK)
                1 -> return convertNuScoAverage(NuScoModelTest.QUERY_HISTORY_MONTH)
                2 -> return convertNuScoAverage(NuScoModelTest.QUERY_HISTORY_YEAR)
                else -> return "C"
            }
        }

        fun convertNuScoAverage(queryString :String) :String{
            var gson = Gson()

            var data = gson.fromJson(queryString, NutriScoreHistory::class.java)
            Log.d("DATA", data.toString())

            return data!!.history!!.nutritionDist!!.profile.toString()
        }

        fun queryProductsByKeyWord(queryProduct: String): List<Product> {
            //TODO request data from back-end

            // returning dummy data for now
            return parseAndConvertQuery(queryProduct)
        }

        fun parseAndConvertQuery(queryProduct: String) : List<Product>{
            val query : String?
            when (queryProduct){
                "milk" -> query = NuScoModelTest.QUERY_MILK
                "banana" -> query = NuScoModelTest.QUERY_BANANA
                "coca-cola" -> query = NuScoModelTest.QUERY_COCACOLA
                else -> query = null
            }
            if (query != null) {
                val result = Klaxon()
                    .parseArray<Product>(query)

                if (result == null) {
                    return emptyList()
                } else {
                    return result
                }
            }else{
                return emptyList()
            }
        }


        fun queryImproveInformation(queryProduct: String) : List<CandidatesItem>{
            //TODO perform GET request to fetch information from back-end

            // return dummy information
            return convertImproveInformation(NuScoModelTest.QUERY_IMPROVE)
        }

        fun convertImproveInformation(queryResponse: String) : List<CandidatesItem> {
            var gson = Gson()
            var data = gson.fromJson(queryResponse, ImproveResponse::class.java)

            return data.recommendations!!.candidates as List<CandidatesItem>
        }


        //---------------- TRIED AND FAILED -------------------//
        // constants
        /*
        val _URL = "http://127.0.0.1:5000/"
        val _REQUEST = "autocomplete/"

        // shit
        var activity: AppCompatActivity? = null

        // DUMMY RESPONSES
        var nuScoRatios = listOf<Float>(0.2f, 0.3f, 0.1f, 0.3f, 0.1f)
        var nuSco: Char = 'D'
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
            var returnedString: String = ""

            val e_url : String = "http://127.0.0.1:5000/autocomplete/milk"
            Log.d("URL",e_url)

            AsyncTaskHandleJson().execute(e_url)

            // returning dummy data for now
            return convertProductsQueryToArray(returnedString)
        }

        private fun convertProductsQueryToArray(answer: String): Array<Products> {
            return dummyQuery
        }

        class AsyncTaskHandleJson : AsyncTask<String, String, String>() {
            override fun doInBackground(vararg url: String?): String {
                var text: String
                val connection = URL(url[0]).openConnection() as HttpURLConnection
                try {
                    connection.connect()
                    text = connection.inputStream.use {
                        it.reader().use {
                                reader -> reader.readText()
                        }
                    }
                    Log.d("CONNECT","Connecting..")
                }catch (e: Exception) {
                    Log.d("EXCEPTION",e.message.toString())
                    text = ""
                }
                finally {
                    connection.disconnect()
                    Log.d("DISCONNECT","Disconnected..")
                }
                return text
            }

            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                handleJson(result)
            }
        }

        private fun handleJson(jsonString: String?) {
            val jsonArray = JSONArray(jsonString)
            Log.d("JSON",jsonString)
        }
         */
    }
}