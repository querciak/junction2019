package com.example.junction2019.jsonmodels


import com.google.gson.annotations.SerializedName

data class Recommendations(

	@field:SerializedName("candidates")
	val candidates: List<CandidatesItem?>? = null,

	@field:SerializedName("oldProd")
	val oldProd: OldProd? = null
)