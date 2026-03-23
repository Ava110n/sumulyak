package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform

@Composable

fun authorization(windows:  MutableState<Windows>, db: DataBase) {
    if(windows.value != Windows.AUTHORIZATION) return

    val log = remember{mutableStateOf("")}
    val pas = remember{mutableStateOf("")}

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        TextField(
            value = log.value,
            textStyle = TextStyle(fontSize = 15.sp),
            onValueChange = {newText -> log.value = newText},
            label = {Text(text = "login")}
        )
        TextField(
            value = pas.value,
            textStyle = TextStyle(fontSize = 15.sp),
            onValueChange = {newText -> pas.value = newText},
            label = {Text(text = "password")}
        )
        TextButton(onClick = {
            db.select(log.value, pas.value)
        }){Text("log in")}
        TextButton(onClick = {windows.value = Windows.REGISTRATION})
        {Text("sign up")}
    }

}