package com.pgustavo.mybank

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowInsetsControllerCompat
import com.pgustavo.mybank.app.App
import com.pgustavo.mybank.core.presentation.AppSurface

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetStatusBarColor(color = AppSurface, useDarkIcons = false)
            App()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetStatusBarColor(color: androidx.compose.ui.graphics.Color, useDarkIcons: Boolean = true) {
    val view = LocalView.current
    val window = (view.context as? Activity)?.window ?: return

    SideEffect {
        window.statusBarColor = color.toArgb()
        WindowInsetsControllerCompat(window, view).isAppearanceLightStatusBars = useDarkIcons
    }
}

