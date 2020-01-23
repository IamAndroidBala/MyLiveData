package com.android.mylivedata.viewmodel

import com.android.mylivedata.networking.RestApiService

class ApiRepository() {

    fun getMutableLiveData()  =  RestApiService.getUsersList()

}