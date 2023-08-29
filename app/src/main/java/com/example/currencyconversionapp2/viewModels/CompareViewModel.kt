package com.example.currencyconversionapp2.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconversionapp.api.model.ConversionResult
import com.example.currencyconversionapp2.api.data.APIRemoteData
import com.example.currencyconversionapp2.api.data.network.APIClient
import com.example.currencyconversionapp2.api.model.ComparisonObject
import com.example.currencyconversionapp2.api.model.ComparisonRates
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CompareViewModel: ViewModel() {


    private val mutableComparisonResultFlow = MutableStateFlow<Double>(0.0)
    val comparisonResultFlow: StateFlow<Double> = mutableComparisonResultFlow


    var errorMessage: String by mutableStateOf("")

    fun convert(current: String, target1: String, target2: String, amount: Double, result: MutableState<String>){
        viewModelScope.launch {
            val apiService = APIClient.getClient()?.create(APIRemoteData::class.java)
            try {
                // val convertRes = apiService?.getConversionResult(base, target, amount)

              //  val comparisonObject = ComparisonObject(current, listOf(target1, target2), result)

              //  val call: Call<ComparisonObject> = apiService!!.compareRates(comparisonObject)


//                call!!.enqueue(object : Callback<ComparisonObject> {
//                    override fun onResponse(call: Call<ComparisonObject>, response: Response<ComparisonRates>) {
//
//                        val model: ComparisonRates? = response.body()
//
//                        val resp =
//                            model!!.additionalProp1
//
//                        //  "Response Code : " + response.code() +
//
//                        result.value = resp.toString()
//                     //   convertResult.value = resp
//                        // mutableConversionResultFlow.value = resp
//                    }
//                    override fun onFailure(call: Call<ComparisonObject>, t: Throwable) {
//                        // we get error response from API.
//                        result.value = "Error found is : " + t.message
//                    }
//
//
//                })
                } catch (e : Exception){
                errorMessage = e.message.toString()
            }


        }

    }

}