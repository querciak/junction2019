package com.example.junction2019.jsonmodels

import com.google.gson.annotations.SerializedName

data class NutritionDist(

	@field:SerializedName("A")
	val A: Double? = null,

	@field:SerializedName("B")
	val B: Double? = null,

	@field:SerializedName("C")
	val C: Double? = null,

	@field:SerializedName("D")
	val D: Double? = null,

	@field:SerializedName("E")
	val E: Double? = null,

	@field:SerializedName("profile")
	val profile: String? = null
)