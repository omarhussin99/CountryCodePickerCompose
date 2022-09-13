package com.omarelkhouledy.countrycodepicker.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.omarelkhouledy.countrycodepicker.R


val Avenir = FontFamily(
    Font(R.font.avenir_light,FontWeight.Light),
    Font(R.font.avenir_regular,FontWeight.Normal),
    Font(R.font.avenir_heavy,FontWeight.Bold)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)