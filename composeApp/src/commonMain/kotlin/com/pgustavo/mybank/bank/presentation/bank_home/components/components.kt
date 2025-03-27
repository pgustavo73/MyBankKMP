package com.pgustavo.mybank.bank.presentation.bank_home.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pgustavo.mybank.bank.presentation.bank_login.components.Visibility
import com.pgustavo.mybank.bank.presentation.bank_login.components.VisibilityOff
import com.pgustavo.mybank.core.presentation.DarkSurface

@Composable
fun TopHeader(name: String) {
    Row(modifier = Modifier.padding(12.dp)) {
        Text("My", fontWeight = FontWeight.Bold)
        Text("Bank")
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = "notifications"
        )
    }
    Row(modifier = Modifier.padding(start = 12.dp)) {
        Text("Hello, ")
        Text(name, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Balance(balance: String) {
    var expanded by remember { mutableStateOf(false) }
    val cardWidth by animateDpAsState(
        targetValue = if (expanded) 250.dp else 50.dp,
        label = "cardWidth"
    )
    var balancedVisible by remember { mutableStateOf(false) }
    val with = if (!balancedVisible) 50.dp else 250.dp
    Card(
        modifier = Modifier
            .width(cardWidth)
            .height(30.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Box(
            modifier = Modifier
                .background(DarkSurface)
                .padding(start = 12.dp, end = 12.dp),
        ) {
            Row(modifier = Modifier.padding(2.dp)) {
                val icon = if (balancedVisible) Visibility else VisibilityOff
                if (balancedVisible) {
                    Text("Balance: $balance")
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = {
                    balancedVisible = !balancedVisible
                    expanded = !expanded
                }) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "notifications"
                    )
                }
            }
        }
    }
}