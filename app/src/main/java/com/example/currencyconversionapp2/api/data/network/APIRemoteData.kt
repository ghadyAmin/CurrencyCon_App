package com.example.currencyconversionapp2.api.data.network

import com.example.currencyconversionapp.api.model.ConversionRate
import com.example.currencyconversionapp.api.model.ConversionResult
import com.example.currencyconversionapp.api.model.Currencies
import com.example.currencyconversionapp.api.model.Currency
import retrofit2.http.GET
import retrofit2.http.Path

interface APIRemoteData {
    @GET("currencies")
    suspend fun getCurrencies(): List<Currency>

    @GET("currencies/{current}/{target}")
    suspend fun getConversionRate(@Path("current") current: String,
                                  @Path("target") target: String): ConversionRate

    @GET("currencies/{current}/{target}/{amount}")
    suspend fun getConversionResult(@Path("current") current: String,
                                    @Path("target") target: String,
                                    @Path("amount") amount : Double): ConversionResult


}