package com.omarelkhouledy.countrycodepicker.util

import android.content.Context
import android.telephony.TelephonyManager
import android.util.Log
import com.omarelkhouledy.countrycodepicker.R
import java.util.*


fun getDeviceCountryCode(context:Context) : String {
    var countryId: String? = null
    var countryDialCode: String? = null
    val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    countryId = tm.simCountryIso.uppercase(Locale.getDefault())
    Log.d("test", "CountriesBottomSheet: ${tm.networkCountryIso}")
    val arrCountryCode: Array<String> = context.resources.getStringArray(R.array.DialingCountryCode)
    for (i in arrCountryCode.indices) {
        val arrDial = arrCountryCode[i].split(",").toTypedArray()
        if (arrDial[1].trim { it <= ' ' } == countryId.trim()) {
            countryDialCode = arrDial[0]
            break
        }
    }
    return countryDialCode!!
}