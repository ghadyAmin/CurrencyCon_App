package com.example.currencyconversionapp.api

import com.example.currencyconversionapp.api.model.CurrenciesRates
import retrofit2.http.GET
interface APIRemoteData {
    @GET("/api/v1/currencies")
    suspend fun retrieveCurrencies(): retrofit2.Response<CurrenciesRates?>?
}