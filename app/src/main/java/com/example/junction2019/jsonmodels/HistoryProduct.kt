package com.example.junction2019.jsonmodels

import com.beust.klaxon.Json

data class HistoryProduct(
    @Json(name = "name")
    val name : String,
    @Json(name = "nutri_score")
    val nutriScore : String
)