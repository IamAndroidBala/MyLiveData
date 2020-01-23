package com.android.mylivedata.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.mylivedata.model.user.User


class UserViewModel() : ViewModel() {

    private val movieRepository = ApiRepository()

    val allBlog: LiveData<List<User>> get() = movieRepository.getMutableLiveData()

}