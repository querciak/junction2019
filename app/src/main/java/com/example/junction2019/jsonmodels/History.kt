package com.example.junction2019.jsonmodels

import com.google.gson.annotations.SerializedName

data class History(

	@field:SerializedName("product_labels")
	val productLabels: List<ProductLabelsItem?>? = null,

	@field:SerializedName("nutrition_dist")
	val nutritionDist: NutritionDist? = null
)