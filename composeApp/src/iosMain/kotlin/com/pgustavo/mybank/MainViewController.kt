package com.pgustavo.mybank

import androidx.compose.ui.window.ComposeUIViewController
import com.pgustavo.mybank.app.App
import com.pgustavo.mybank.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }