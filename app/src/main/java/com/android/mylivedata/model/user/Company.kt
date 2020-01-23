package com.android.mylivedata.model.user

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Company(var name : String, var catchPhrase : String, var bs : String) : Parcelable