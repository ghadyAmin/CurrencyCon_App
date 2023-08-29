package com.example.currencyconversionapp.api
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconversionapp.api.model.ConversionResult
import com.example.currencyconversionapp.api.model.Currency
import com.example.currencyconversionapp2.api.data.network.APIClient
import com.example.currencyconversionapp2.api.data.APIRemoteData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIViewModel(): ViewModel() {
//
//    var currentComparedFrom = MutableStateFlow<String>("")
//    var currentComparedTo1 = MutableStateFlow<String>("")
//    var currentComparedTo2 = MutableStateFlow<String>("")
//    var currentCompareAmount = MutableStateFlow<String>("")
//
//
//
//    var currentSelectedToCurrency = MutableStateFlow<String>("")
//    var currentSelectedAmount = MutableStateFlow<String>("")
//    var currentSelectedFromCurrency = MutableStateFlow<String>("")
//
//
//
//
//
//
//    private val mutableCurrenciesFlow = MutableStateFlow<List<Currency>?>(null)
//    val currenciesFlow: StateFlow<List<Currency>?> = mutableCurrenciesFlow
//
//
//    private val mutableConversionResultFlow = MutableStateFlow<ConversionResult?>(null)
//    val conversionResultFlow: StateFlow<ConversionResult?> = mutableConversionResultFlow
//
//
//
//
//
//
//    fun getCurrency(context: Context) {
//        val mainActivityRemoteData =
//            APIClient.getClient()?.create(APIRemoteData::class.java)
//        viewModelScope.launch {
//            //    try{
//            withContext(Dispatchers.IO) {
//                val response = mainActivityRemoteData?.getCurrencies()
//                val currency = mainActivityRemoteData?.getCurrencies()
////                    withContext(Dispatchers.Main){
////
////                        if (response?.isSuccessful == true){
////                            Log.e("MainActivityViewModel", "getUserInfo --->")
////                        }
////                        if(response?.code() == 500){
////
////
////                            println("$currency")
////
////                            // Toast.makeText(, currency, Toast.LENGTH_LONG).show()
////                            //  Toast.makeText(this@MainActivityViewModel, currency, Toast.LENGTH_LONG).show()
////
////                        }
////                        if(response?.code() == 999){
////                            Log.e("MainActivityViewModel", "Not Updated")
////                        }
////                    }
////                }
////
////            }
////            catch (error: Exception){
////                Log.e("MainActivityViewModel", "getCurrencies --->" + error.message)
////            }
//
//            }
//
//        }
//
//
////    fun retrieveDataWithRetrofit() {
////        viewModelScope.launch {
////            val interceptor = HttpLoggingInterceptor()
////            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
////            val client: OkHttpClient = OkHttpClient()
////                .newBuilder().addInterceptor(interceptor).build()
////            val retrofit = Retrofit.Builder()
////                .baseUrl("https://concurrency-api.onrender.com/api/v1/")
////                .addConverterFactory(GsonConverterFactory.create())
////                .client(client)
////                .build()
////
////
////            val currencyAPI = retrofit.create(APIRemoteData::class.java)
////            val currency = currencyAPI.getCurrencies()
////
////
////            val getConversionRate = currencyAPI.getConversionResult(currentSelectedFromCurrency.value,
////                currentSelectedToCurrency.value,  currentSelectedAmount.value.toDouble() )
////
////
////
////            mutableCurrenciesFlow.value = currency
////
////
////
////
////
////            //  val getConversionResult = currencyAPI.getConversionResult("EGP", "USD", "70")
////            Log.d("Network", currency.toString())
////
////        }
////    }
//    }
//
//
//    fun convertResult(){
//        viewModelScope.launch {
//            val retrofit = Retrofit.Builder()
//                .baseUrl("https://concurrency-api.onrender.com/api/v1/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//
//
//            val currencyAPI = retrofit.create(APIRemoteData::class.java)
//
//
//
//            val conversionResult = currencyAPI.getConversionResult(currentSelectedFromCurrency.value,
//                currentSelectedToCurrency.value, currentSelectedAmount.value.toDouble())
//
//            mutableConversionResultFlow.value = conversionResult
//
//
//
//
//
//        }
//    }
    }


















