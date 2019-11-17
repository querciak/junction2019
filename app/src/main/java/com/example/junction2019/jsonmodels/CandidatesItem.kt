package com.example.junction2019.jsonmodels

import com.google.gson.annotations.SerializedName

data class CandidatesItem(

	@field:SerializedName("score")
	val score: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)