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

fun registration(windows: MutableState<Windows>, db: DataBase) {
    if(windows.value != Windows.REGISTRATION) return

    var log by remember{mutableStateOf("")}
    var pas by remember{mutableStateOf("")}
    var name by remember {mutableStateOf("")}
    var pas_conf by remember {mutableStateOf("")}


    TextButton(onClick = {windows.value = Windows.AUTHORIZATION}){Text("back")}

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        TextField(
            value = name,
            textStyle = TextStyle(fontSize = 15.sp),
            onValueChange = {newText -> name = newText},
            label = {Text(text = "name")}
        )
        TextField(
            value = log,
            textStyle = TextStyle(fontSize = 15.sp),
            onValueChange = {newText -> log = newText},
            label = {Text(text = "login")}
        )
        TextField(
            value = pas,
            textStyle = TextStyle(fontSize = 15.sp),
            onValueChange = {newText -> pas = newText},
            label = {Text(text = "password")}
        )
        TextField(
            value = pas_conf,
            textStyle = TextStyle(fontSize = 15.sp),
            onValueChange = {newText -> pas_conf = newText},
            label = {Text(text = "password confirm")}
        )
        TextButton(onClick = {
            if(name == ""){
                return@TextButton
            }
            if(log == ""){
                return@TextButton
            }
            if(pas == ""){
                return@TextButton
            }
            if(pas != pas_conf){
                return@TextButton
            }
            db.insert(name, log, pas)
        }){Text("sing up")}
    }
}