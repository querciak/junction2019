package com.example.junction2019.jsonmodels

import com.google.gson.annotations.SerializedName

data class ProductLabelsItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("nutri_score")
	val nutriScore: String? = null
)