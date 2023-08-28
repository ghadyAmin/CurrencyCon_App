package com.example.currencyconversionapp.api.model

data class ConversionResult(
    val base_code: String,
    val target_code: String,
    val conversion_rate: Double,
    val conversion_result: Double
)