package com.android.mylivedata.network

import com.android.mylivedata.model.user.User
import com.android.mylivedata.utils.AppConstants
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET(AppConstants.User_Api)
    abstract fun getUser(): Call<List<User>>

}