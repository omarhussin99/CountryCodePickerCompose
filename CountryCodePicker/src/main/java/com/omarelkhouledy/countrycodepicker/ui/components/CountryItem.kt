package com.omarelkhouledy.countrycodepicker.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omarelkhouledy.countrycodepicker.data.model.Country
import com.omarelkhouledy.countrycodepicker.theme.Avenir

@Composable
fun CountryItem (country: Country,onCLick: () ->Unit){
    val context = LocalContext.current
    Row(modifier = Modifier.fillMaxWidth().clickable { onCLick() }) {
        Text(modifier = Modifier.padding
            (start = 24.dp, end = 24.dp , top = 10.dp, bottom = 10.dp),
            text = "${country.image}  ${context.getString(country.name)}  (+${country.countryCode})" ,
            style = TextStyle(
                color = Color(0xFF505255),
                fontSize = 14.sp,
                fontFamily = Avenir,
            )
        )
    }
}