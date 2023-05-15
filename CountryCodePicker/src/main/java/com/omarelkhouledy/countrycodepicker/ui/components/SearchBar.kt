@file:OptIn(ExperimentalComposeUiApi::class)
@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.omarelkhouledy.countrycodepicker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omarelkhouledy.countrycodepicker.R
import com.omarelkhouledy.countrycodepicker.theme.Avenir

@Composable
fun SearchBar(
    placeholder: String = "",
    searchTerm: (String) -> Unit = {},
    searchString: String = "",
    openKeyboard: Boolean = false,
    onClear: () -> Unit = {}
) {
    var searchTermValue by rememberSaveable(searchString) { mutableStateOf(searchString) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }

    Row(
        modifier = Modifier
            .padding(top = 14.dp, bottom = 4.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        BasicTextField(
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .height(40.dp)
                .weight(1f)
                .border(1.dp, Color(0xFFF2F4F8), RoundedCornerShape(8.dp))
                .clip(RoundedCornerShape(8.dp))
                .background(
                    color = White,
                    shape = RoundedCornerShape(8.dp)
                )
                .focusRequester(focusRequester),
            value = searchTermValue,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions { keyboardController?.hide() } ,
            onValueChange = {
                searchTermValue = it
                searchTerm(searchTermValue.trim())
            },
            singleLine = true,
            cursorBrush = SolidColor(Color(0xFFAEB8C5)),
            textStyle = TextStyle(
                color = Color(0xFF697077),
                fontSize = 12.sp,
                fontFamily = Avenir,
                lineHeight = 16.sp
            ),
            decorationBox = { innerTextField ->
                Row(
                    Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.search_icon),
                        contentDescription = "Search Icon",
                        tint = Color(0xFFAEB8C5),
                        modifier = Modifier
                            .padding(start = 12.dp, end = 6.dp)
                            .size(14.dp)
                    )
                    Box(Modifier.weight(1f)) {
                        Text(
                            if (searchTermValue.isEmpty() && !openKeyboard)
                                placeholder else "",
                            style = TextStyle(
                                color = Color(0xFFAEB8C5),
                                fontSize = 12.sp,
                                fontFamily = Avenir,
                                lineHeight = 16.sp,
                            )
                        )
                        innerTextField()
                    }
                    if (searchTermValue != "") {
                        IconButton(onClick = {
                            searchTermValue = ""
                            onClear()
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_cancel),
                                contentDescription = "Clear Search",
                                tint = LightGray,
                                modifier = Modifier
                                    .size(14.dp)
                            )
                        }
                    }
                }
            }
        )
        Spacer(modifier = Modifier.width(20.dp))
    }

}