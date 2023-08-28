package com.example.currencyconversionapp.api
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconversionapp.api.model.ConversionResult
import com.example.currencyconversionapp.api.model.Currencies
import com.example.currencyconversionapp.api.model.Currency
import com.example.currencyconversionapp2.api.data.network.APIRemoteData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIViewModel(): ViewModel() {

    var currentComparedFrom = MutableStateFlow<String>("")
    var currentComparedTo1 = MutableStateFlow<String>("")
    var currentComparedTo2 = MutableStateFlow<String>("")
    var currentCompareAmount = MutableStateFlow<String>("")



    var currentSelectedToCurrency = MutableStateFlow<String>("")
    var currentSelectedAmount = MutableStateFlow<String>("")
    var currentSelectedFromCurrency = MutableStateFlow<String>("")






    private val mutableCurrenciesFlow = MutableStateFlow<List<Currency>?>(null)
    val currenciesFlow: StateFlow<List<Currency>?> = mutableCurrenciesFlow


    private val mutableConversionResultFlow = MutableStateFlow<ConversionResult?>(null)
    val conversionResultFlow: StateFlow<ConversionResult?> = mutableConversionResultFlow





    fun retrieveDataWithRetrofit() {
        viewModelScope.launch {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client: OkHttpClient = OkHttpClient().newBuilder().addInterceptor(interceptor).build()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://concurrency-api.onrender.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()


            val currencyAPI = retrofit.create(APIRemoteData::class.java)
            val currency = currencyAPI.getCurrencies()


            val getConversionRate = currencyAPI.getConversionResult(currentSelectedFromCurrency.value,
                currentSelectedToCurrency.value,  currentSelectedAmount.value.toDouble() )



            mutableCurrenciesFlow.value = currency





            //  val getConversionResult = currencyAPI.getConversionResult("EGP", "USD", "70")
            Log.d("Network", currency.toString())

        }
    }



    fun convertResult(){
        viewModelScope.launch {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://concurrency-api.onrender.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()


            val currencyAPI = retrofit.create(APIRemoteData::class.java)



            val conversionResult = currencyAPI.getConversionResult(currentSelectedFromCurrency.value,
                currentSelectedToCurrency.value, currentSelectedAmount.value.toDouble())

            mutableConversionResultFlow.value = conversionResult





        }
    }





}












