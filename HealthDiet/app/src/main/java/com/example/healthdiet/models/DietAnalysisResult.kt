package com.example.healthdiet.models

data class DietAnalysisResult(
    val foodName: String,
    val accuracy: Float,
    val calories: Int,
    val nutritionInfo: NutritionInfo
)

data class NutritionInfo(
    val protein: Float,
    val carbs: Float,
    val fat: Float,
    val fiber: Float,
    val sugar: Float,
    val servingSize: Float,
    val servingUnit: String,
    val healthScore: Int,
    val dietaryRestrictions: List<String>,
    val allergens: List<String>
)
