package com.pgustavo.mybank.bank.presentation.bank_home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pgustavo.mybank.bank.presentation.bank_home.components.Balance
import com.pgustavo.mybank.bank.presentation.bank_home.components.CreditCard
import com.pgustavo.mybank.bank.presentation.bank_home.components.TopHeader
import com.pgustavo.mybank.core.presentation.Appsurface
import com.pgustavo.mybank.core.presentation.DarkSurface
import com.pgustavo.mybank.core.presentation.formatCurrency


@Composable
fun BankHomeScreen(balance: String?, name: String) {
    Column {
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            color = Appsurface,
            shape = RoundedCornerShape(
                bottomStart = 30.dp
            )
        ) {
            Column {
                TopHeader(name)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CreditCard("1234567890123456", name, "12/28")
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Balance(balance ?: "0.0")
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}
