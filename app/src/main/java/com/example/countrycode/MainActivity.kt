package com.example.countrycode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.example.countrycode.ui.theme.CountryCodeTheme
import com.omarelkhouledy.countrycodepicker.ui.components.CountriesBottomSheet
import com.omarelkhouledy.countrycodepicker.ui.components.CountryCodePicker

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val currentLocationSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
            CountryCodeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CountriesBottomSheet(currentLocationSheetState) {
                        Column {
                            CountryCodePicker(country = it,currentLocationSheetState)
                        }
                    }
                }
            }
        }
    }
}

