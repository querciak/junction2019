package com.example.junction2019.jsonmodels

import com.google.gson.annotations.SerializedName

data class ImproveResponse(

	@field:SerializedName("recommendations")
	val recommendations: Recommendations? = null
)