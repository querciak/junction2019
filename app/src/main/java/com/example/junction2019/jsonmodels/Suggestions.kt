package com.example.junction2019.jsonmodels

import com.beust.klaxon.Json

data class Suggestions(
    @Json(name = "suggestions")
    var suggestions :String
)