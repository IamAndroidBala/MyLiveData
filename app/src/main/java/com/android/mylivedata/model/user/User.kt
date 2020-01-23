package com.android.mylivedata.model.user

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(var id       : Int,
                var name     : String,
                var username : String,
                var email    : String,
                var address  : Address,
                var phone    : String,
                var website  : String,
                var company  : Company
                ) : Parcelable {}