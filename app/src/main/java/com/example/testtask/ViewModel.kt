package com.example.testtask

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testtask.model.BIN
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ViewModel : ViewModel() {
    val resultBin = MutableLiveData<BIN?>()

    fun checkBin(bin: Long) {
        provideApi().checkedBin(bin).enqueue(object : Callback<BIN> {
            override fun onResponse(
                call: Call<BIN>,
                response: Response<BIN>,
            ) {
                if (response.isSuccessful) {
                    val resp = response.body()
                    if (resp != null) {
                        resultBin.value = resp
                    }
                }
            }

            override fun onFailure(call: Call<BIN>, t: Throwable) {
                Log.e("RetrofitViewModel", t.message.toString())
            }

        })
    }
}


