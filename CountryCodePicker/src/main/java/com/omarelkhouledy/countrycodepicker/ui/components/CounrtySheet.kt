package com.omarelkhouledy.countrycodepicker.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.omarelkhouledy.countrycodepicker.data.model.Country
import com.omarelkhouledy.countrycodepicker.data.repository.CountryRepository
import com.omarelkhouledy.countrycodepicker.util.Keyboard
import com.omarelkhouledy.countrycodepicker.util.getDeviceCountryCode
import com.omarelkhouledy.countrycodepicker.util.keyboardAsState
import kotlinx.coroutines.launch



@OptIn(ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
@Composable
fun CountriesBottomSheet(
    modalBottomSheetState: ModalBottomSheetState,
    sheetContent : @Composable (country :Country)-> Unit
) {
    val context = LocalContext.current
    val countryRepository = CountryRepository()
    val scope = rememberCoroutineScope()
    var searchTerm by rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val selectedCountry = remember {
        mutableStateOf(countryRepository.getCountries().find { it.countryCode == getDeviceCountryCode(context) })
    }

    if (!modalBottomSheetState.isVisible) {
        keyboardController?.hide()
    }

    ModalBottomSheetLayout(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize(),
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp),
        sheetContent = {
            Column {
                Divider(
                    Modifier
                        .padding(top = 20.dp, bottom = 8.dp)
                        .width(40.dp)
                        .height(4.dp)
                        .align(Alignment.CenterHorizontally)
                        .clip(RoundedCornerShape(4.dp))
                        .clickable { scope.launch { modalBottomSheetState.hide() } })
                SearchBar(
                    placeholder = "Search for country",
                    searchTerm = { searchTerm = it },
                    searchString = searchTerm,
                    openKeyboard = false,
                    onClear = { searchTerm = "" },
                )
                LazyColumn(
                    modifier = Modifier.height(
                        if (keyboardAsState().value == Keyboard.Opened) {
                            500
                        } else {
                            350
                        }.dp
                    )
                ) {
                    items(
                        if (searchTerm != "") countryRepository.getCountries().filter {
                            context.getString(it.name).lowercase().contains(searchTerm.trim().lowercase())
                        } else countryRepository.getCountries(),
                        key = { it.name }) { country ->
                        CountryItem(country = country) {
                           selectedCountry.value = country
                            scope.launch {
                                modalBottomSheetState.hide()
                            }
                        }
                        Divider(Modifier.padding(start = 22.dp, end = 22.dp))
                    }
                }
            }
        }
    ) {
        if (selectedCountry.value != null) {
            sheetContent(selectedCountry.value!!)
        }
    }
}