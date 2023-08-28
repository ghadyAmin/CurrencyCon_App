package com.example.currencyconversionapp.api.model
data class Currency(
    val name: String,
    val code: String,
    val icon_url: String
)

data class Currencies(
    val currencies: List<Currency>,
)