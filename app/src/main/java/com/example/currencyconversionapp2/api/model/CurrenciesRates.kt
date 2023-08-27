package com.example.currencyconversionapp.api.model

data class CurrenciesRates (
    val currencies: CurrenciesItem,
    val rates: CurrenciesRates

)