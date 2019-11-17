package com.example.junction2019.jsonmodels

import com.beust.klaxon.Json

data class NutriScore(
    @Json(name = "nutrition_dist")
    val nutriScoreHist : String,
    @Json(name = "product_labels")
    val productHistory : String
)