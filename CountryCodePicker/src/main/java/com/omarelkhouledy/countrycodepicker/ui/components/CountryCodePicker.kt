package com.omarelkhouledy.countrycodepicker.ui.components

import com.omarelkhouledy.countrycodepicker.theme.Avenir

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omarelkhouledy.countrycodepicker.data.model.Country
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CountryCodePicker(country: Country,bottomSheetState: ModalBottomSheetState) {
    val scope = rememberCoroutineScope()
    Row(modifier = Modifier.padding(start = 20.dp, end = 10.dp)
            .border(1.dp, Color(0xFFF2F4F8), RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = { scope.launch { bottomSheetState.show() } })
        ) {
            Text(text = country.image,
                style = TextStyle(
                    color = Color(0xFF697077),
                    fontSize = 14.sp,
                    fontFamily = Avenir,
                    lineHeight = 16.sp,
                ),
                modifier = Modifier.padding(10.dp)
            )
           Text(text = " +${country.countryCode}",
            style = TextStyle(
                color = Color(0xFF697077),
                fontSize = 12.sp,
                fontFamily = Avenir,
                lineHeight = 16.sp,
            ),
            modifier = Modifier.padding(10.dp)
           )
        }
}