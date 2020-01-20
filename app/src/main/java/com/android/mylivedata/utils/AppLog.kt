package com.android.mylivedata.utils

import android.util.Log

class AppLog {

    companion object {

        fun d(message : String) {
            if(AppConstants.Is_Test_Build && message.isNotBlank()) {
                Log.d("MyLiveDataApp", " ====> $message")
            }
        }

    }

}