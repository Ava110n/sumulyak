package org.example.project

import java.awt.Dimension
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KotlinProject",
    ) {
        window.minimumSize = Dimension(500, 400)
        App()
    }
}