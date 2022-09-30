package com.omarelkhouledy.countrycodepicker.data.repository

import com.omarelkhouledy.countrycodepicker.R
import com.omarelkhouledy.countrycodepicker.data.model.Country

class CountryRepository {
    fun getCountries(): List<Country> = listOf(
        //A
        Country("\uD83C\uDDE6\uD83C\uDDEB", R.string.Afghanistan, "93","af"),
        Country("\uD83C\uDDE6\uD83C\uDDF1", R.string.albania, "355","al"),
        Country("\uD83C\uDDE9\uD83C\uDDFF", R.string.algeria, "213","dz"),
        Country("\uD83C\uDDE6\uD83C\uDDF8", R.string.american_samoa, "684","as"),
        Country("\uD83C\uDDE6\uD83C\uDDE9", R.string.andorra, "376","ad"),
        Country("\uD83C\uDDE6\uD83C\uDDF4", R.string.angola, "244","ao"),
        Country("\uD83C\uDDE6\uD83C\uDDEE", R.string.anguilla, "264","ai"),
        Country("\uD83C\uDDE6\uD83C\uDDEC", R.string.antigua_and_barbuda, "268","ag"),
        Country("\uD83C\uDDE6\uD83C\uDDF7", R.string.argentina, "54","ar"),
        Country("\uD83C\uDDE6\uD83C\uDDF2", R.string.armenia, "374","am"),
        Country("\uD83C\uDDE6\uD83C\uDDFC", R.string.aruba, "297","aw"),
        Country("\uD83C\uDDE6\uD83C\uDDFA", R.string.australia, "61","au"),
        Country("\uD83C\uDDE6\uD83C\uDDF9", R.string.austria, "43","at"),
        Country("\uD83C\uDDE6\uD83C\uDDFF", R.string.azerbaijan, "994","az"),
        //B
        Country("\uD83C\uDDF8\uD83C\uDDE6", R.string.saudi_arabia, "966","sa"),
        Country("\uD83C\uDDEA\uD83C\uDDEC", R.string.egypt, "20","eg"),
        Country("\uD83C\uDDFA\uD83C\uDDF8", R.string.untied_states, "1","un")

//        Country("\uD83C\uDDE7\uD83C\uDDED", "Bahrain", "973"),
//        Country("\uD83C\uDDF6\uD83C\uDDE6", "Qatar", "974"),
//        Country("\uD83C\uDDE6\uD83C\uDDEA", "United Arab Emirates", "971"),
//        Country("\uD83C\uDDEC\uD83C\uDDE7", "England", "44"),
//        Country("\uD83C\uDDE7\uD83C\uDDF7", "Brazil", "55"),
//        Country("\uD83C\uDDE8\uD83C\uDDE6", "Canada", "1"),
//        Country("\uD83C\uDDEB\uD83C\uDDF7", "France", "33"),
//        Country("\uD83C\uDDE9\uD83C\uDDEA", "Germany", "49"),
    )
}