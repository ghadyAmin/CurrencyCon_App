package com.example.currencyconversionapp.api
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconversionapp.api.model.Currencies
import com.example.currencyconversionapp.api.model.Currency
import com.example.currencyconversionapp2.api.data.network.APIRemoteData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIViewModel(): ViewModel() {
    private val mutableCurrenciesFlow = MutableStateFlow<List<Currency>?>(null)
    val currenciesFlow: StateFlow<List<Currency>?> = mutableCurrenciesFlow

    fun retrieveDataWithRetrofit() {
        viewModelScope.launch {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://concurrency-api.onrender.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()


            val currencyAPI = retrofit.create(APIRemoteData::class.java)
            val currency = currencyAPI.getCurrencies()

            mutableCurrenciesFlow.value = currency

            val getConversionRate = currencyAPI.getConversionRate("EGP", "USD")
            val getConversionResult = currencyAPI.getConversionResult("EGP", "USD", 70.0)
            Log.d("Network", currency.toString())

        }
    }





//    private val installer = getApplication<Application>().packageManager.packageInstaller
//
//    private val resolver = getApplication<Application>().contentResolver
//

//
//
//
//
//    fun getCurrency(context: Context) {
//        val mainActivityRemoteData =
//            APIClient.getClient()?.create(APIRemoteData::class.java)
//        viewModelScope.launch {
//            try{
//                withContext(Dispatchers.IO){
//                    val response = mainActivityRemoteData?.retrieveCurrencies()
//                    val currency = response?.body()?.size
//
//
//
//
//                  //  mutableCurrenciesFlow.value = currencies
//                    withContext(Dispatchers.Main){
//
//                        if (response?.isSuccessful == true){
//                            Log.e("MainActivityViewModel", "getUserInfo --->")
//                        }
//                        if(response?.code() == 500){
//
//
//                            println("$currency")
//
//                            // Toast.makeText(, currency, Toast.LENGTH_LONG).show()
//                            //  Toast.makeText(this@MainActivityViewModel, currency, Toast.LENGTH_LONG).show()
//
//                        }
//                        if(response?.code() == 999){
//                            Log.e("MainActivityViewModel", "Not Updated")
//                        }
//                    }
//                }
//
//            }
//            catch (error: Exception){
//                Log.e("MainActivityViewModel", "getCurrencies --->" + error.message)
//            }
//
//        }
//
//    }
//
////    var listCurrency = mutableListOf<Currencies>()
////    init {
////
////        viewModelScope.launch {
////            val mainActivityRemoteData =
////                APIClient.getClient()?.create(APIRemoteData::class.java)
////            val response = mainActivityRemoteData?.retrieveCurrencies()
////
////            //do the network call (this is working ok)
////            val curList = getCurrency()
////
////        }
////
////
////        }
//




}

