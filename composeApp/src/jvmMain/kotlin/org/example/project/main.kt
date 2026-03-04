package org.example.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.awt.Dimension

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KotlinProject",

    ) {
        window.minimumSize = Dimension(500, 400)
        App()
    }
}