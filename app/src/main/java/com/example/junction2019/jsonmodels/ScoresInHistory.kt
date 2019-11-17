package com.example.junction2019.jsonmodels

import com.beust.klaxon.Json

data class ScoresInHistory(
    @Json(name = "A")
    val scoreA : Float,
    @Json(name = "B")
    val scoreB : Float,
    @Json(name = "C")
    val scoreC : Float,
    @Json(name = "D")
    val scoreD : Float,
    @Json(name = "E")
    val scoreE : Float,
    @Json(name = "profile")
    val profile : String
)