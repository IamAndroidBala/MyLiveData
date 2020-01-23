package com.android.mylivedata.model.user

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Address(var street : String, var suite : String, var city : String, var zipcode : String, var geo : Geo) : Parcelable {}