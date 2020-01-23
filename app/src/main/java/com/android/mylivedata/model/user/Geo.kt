package com.android.mylivedata.model.user

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Geo(var lat : String, var lng : String) : Parcelable {}