package com.pgustavo.mybank.bank.presentation.bank_home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun BankHomeScreen(balance: String?, name: String) {
    Column {
        Text("Home Screen")

        Text("Hello $name !")
        Text("Your balence is: $balance")
    }
}
