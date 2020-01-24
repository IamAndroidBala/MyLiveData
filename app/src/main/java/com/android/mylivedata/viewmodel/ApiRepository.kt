package com.android.mylivedata.viewmodel

import com.android.mylivedata.network.RestApiService

class ApiRepository() {

    fun getMutableLiveData()  =  RestApiService.getUsersList()

}