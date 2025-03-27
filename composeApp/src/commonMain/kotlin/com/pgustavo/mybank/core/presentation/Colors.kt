package com.pgustavo.mybank.core.presentation

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val AppBlack = Color(0xFF000000)
val AppWhite = Color(0xFFFFFFFF)
val AppBase = Color(red = 103, green = 80, blue =164)
val Appsurface = Color(red = 246, green = 148, blue =6 )
val DarkSurface = Color(214,128,3)
val DarkCard = Color(97,93,93)
val LightCard = Color(193,190,190)


internal val LightColorScheme = lightColorScheme(
    primary = Appsurface,
    background = AppWhite,
    onBackground = AppWhite,
    surface = Appsurface,
    onSurface = AppBlack,
)