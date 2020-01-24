package com.android.mylivedata.network

import androidx.lifecycle.MutableLiveData
import com.android.mylivedata.model.user.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface RestApiService {

    companion object {

        fun getUsersList() : MutableLiveData<List<User>> {

            val userData = MutableLiveData<List<User>>()

            RetrofitClient.createService(ApiInterface::class.java).getUser().enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    if (response.isSuccessful) {
                        userData.value = response.body()
                    }
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    userData.value = null
                }
            })

            return userData

        }

    }
}