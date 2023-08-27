package com.example.currencyconversionapp.api
import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconversionapp.api.network.APIClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class APIViewModel(application: Application): AndroidViewModel(application) {
    private val installer = getApplication<Application>().packageManager.packageInstaller

    private val resolver = getApplication<Application>().contentResolver


    fun getCurrency(context: Context) {
        val mainActivityRemoteData =
            APIClient.getClient()?.create(APIRemoteData::class.java)
        viewModelScope.launch {
            try{
                withContext(Dispatchers.IO){
                    val response = mainActivityRemoteData?.retrieveCurrencies()
                    val currency = response?.body()?.currencies?.code
                    withContext(Dispatchers.Main){

                        if (response?.isSuccessful == true){
                            Log.e("MainActivityViewModel", "getUserInfo --->")
                        }
                        if(response?.code() == 500){


                            println("$currency")

                            // Toast.makeText(, currency, Toast.LENGTH_LONG).show()
                            //  Toast.makeText(this@MainActivityViewModel, currency, Toast.LENGTH_LONG).show()

                        }
                        if(response?.code() == 999){
                            Log.e("MainActivityViewModel", "Not Updated")
                        }
                    }
                }

            }
            catch (error: Exception){
                Log.e("MainActivityViewModel", "getCurrencies --->" + error.message)
            }

        }

    }
}

