package com.omarelkhouledy.countrycodepicker.data.model

import androidx.annotation.StringRes


data class Country (
    val image: String,
    @StringRes val name:Int,
    val countryCode:String,
    val countryCodeByLatter:String
    )