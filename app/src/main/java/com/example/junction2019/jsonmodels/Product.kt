package com.example.junction2019.jsonmodels

import com.beust.klaxon.Json

data class Product(
    @Json(name = "payload")
    val barcode: String,
    @Json(name = "suggestion")
    val suggestion: String
)