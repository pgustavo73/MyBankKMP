package com.pgustavo.mybank.core.presentation

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val AppBlack = Color(0xFF000000)
val AppWhite = Color(0xFFFFFFFF)
val AppBase = Color(red = 103, green = 80, blue =164)
val Appsurface = Color(red = 246, green = 148, blue =6 )


internal val LightColorScheme = lightColorScheme(
    primary = Appsurface,
    background = AppWhite,
    onBackground = AppWhite,
    surface = Appsurface,
    onSurface = AppBlack,
)