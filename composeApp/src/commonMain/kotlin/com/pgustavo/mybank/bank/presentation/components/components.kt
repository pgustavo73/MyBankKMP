package com.pgustavo.mybank.bank.presentation.components

import airplane
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import banknote
import barcode_scanner
import com.pgustavo.mybank.app.App
import com.pgustavo.mybank.bank.domain.Moviment
import com.pgustavo.mybank.bank.presentation.components.Icons.Visibility
import com.pgustavo.mybank.bank.presentation.components.Icons.VisibilityOff
import com.pgustavo.mybank.core.presentation.AppBase
import com.pgustavo.mybank.core.presentation.AppBlack
import com.pgustavo.mybank.core.presentation.AppSurface
import com.pgustavo.mybank.core.presentation.AppWhite
import com.pgustavo.mybank.core.presentation.DarkSurface
import com.pgustavo.mybank.core.presentation.sumExpense
import com.pgustavo.mybank.core.presentation.sumIncome
import gamepad
import mobile
import others
import transfer

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

@Composable
fun SquareButton(
    text: String,
    onClick: () -> Unit,
    icon: ImageVector
) {
    Box(
        modifier = Modifier.size(80.dp)
            .padding(6.dp)
            .clickable { onClick() }
            .border(
                color = AppSurface, width = 1.dp,
                shape = RoundedCornerShape(size = 6.dp)
            )
            .background(AppBase, shape = RoundedCornerShape(6.dp)),
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = AppSurface,
                    modifier = Modifier.size(30.dp)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = text, fontSize = 10.sp, color = AppSurface)
            }
        }
    }
}

@Composable
fun ButtonsBlock() {
    Box(
        modifier = Modifier.fillMaxWidth()
            .padding(3.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                SquareButton("Shop", onClick = {}, Icons.Filled.ShoppingCart)
                SquareButton("Withdraw", onClick = {}, banknote)
                SquareButton("Transfer", onClick = {}, transfer)
                SquareButton("Mobile", onClick = {}, mobile)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                SquareButton("Payments", onClick = {}, barcode_scanner)
                SquareButton("Travel", onClick = {}, airplane)
                SquareButton("Game", onClick = {}, gamepad)
                SquareButton("Others", onClick = {}, others)
            }
        }
    }
}

@Composable
fun BottomScreen(moviments: List<Moviment>) {
    Card(
        modifier = Modifier
            .width(350.dp)
            .height(120.dp)
            .padding(18.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppWhite
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(6.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Column(
                modifier = Modifier
                    .width(125.dp)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text("Income", color = AppSurface)
                Spacer(modifier = Modifier.height(8.dp))
                Text(sumIncome(moviments), color = Color.Green)
            }
            VerticalDivider(thickness = 1.dp, color = AppBase)
            Column(
                modifier = Modifier
                    .width(125.dp)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text("Expense", color = AppSurface)
                Spacer(modifier = Modifier.height(8.dp))
                Text(sumExpense(moviments), color = Color.Red)
            }

        }
    }
}
