package com.pgustavo.mybank.core.presentation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun Theme(
    theme: Boolean = isSystemInDarkTheme(), // Checks if your system is in dark theme mode.
    content: @Composable () -> Unit
) {
    val colors =  LightColorScheme
    MaterialTheme(
        colorScheme = colors,
        content = content,
    )
}