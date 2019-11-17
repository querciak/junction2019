package com.example.junction2019.jsonmodels


import com.google.gson.annotations.SerializedName

data class NutriScoreHistory(

	@field:SerializedName("history")
	val history: History? = null
)