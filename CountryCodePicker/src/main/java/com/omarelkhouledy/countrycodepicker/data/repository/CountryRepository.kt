package com.omarelkhouledy.countrycodepicker.data.repository

import com.omarelkhouledy.countrycodepicker.data.model.Country

class CountryRepository {
    fun getCountries(): List<Country> = listOf(
        Country("\uD83C\uDDF8\uD83C\uDDE6", "Saudi Arabia", "966"),
        Country("\uD83C\uDDEA\uD83C\uDDEC", "Egypt", "20"),
        Country("\uD83C\uDDE7\uD83C\uDDED", "Bahrain", "973"),
        Country("\uD83C\uDDF6\uD83C\uDDE6", "Qatar", "974"),
        Country("\uD83C\uDDE6\uD83C\uDDEA", "United Arab Emirates", "971"),
        Country("\uD83C\uDDEC\uD83C\uDDE7", "England", "44"),
        Country("\uD83C\uDDE7\uD83C\uDDF7", "Brazil", "55"),
        Country("\uD83C\uDDE8\uD83C\uDDE6", "Canada", "1"),
        Country("\uD83C\uDDEB\uD83C\uDDF7", "France", "33"),
        Country("\uD83C\uDDE9\uD83C\uDDEA", "Germany", "49"),
        Country("\uD83C\uDDFA\uD83C\uDDF8", "Untied states", "1")
    )
}