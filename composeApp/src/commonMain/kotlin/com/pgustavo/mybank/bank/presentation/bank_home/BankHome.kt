package com.pgustavo.mybank.bank.presentation.bank_home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pgustavo.mybank.bank.domain.Moviment
import com.pgustavo.mybank.bank.presentation.components.Balance
import com.pgustavo.mybank.bank.presentation.components.BottomScreen
import com.pgustavo.mybank.bank.presentation.components.ButtonsBlock
import com.pgustavo.mybank.bank.presentation.components.CreditCard
import com.pgustavo.mybank.bank.presentation.components.StatementCard
import com.pgustavo.mybank.bank.presentation.components.TopHeader
import com.pgustavo.mybank.core.domain.Result
import com.pgustavo.mybank.core.presentation.AppBase
import com.pgustavo.mybank.core.presentation.AppSurface
import com.pgustavo.mybank.core.presentation.AppWhite
import kotlinx.coroutines.delay
import mybank.composeapp.generated.resources.Res
import mybank.composeapp.generated.resources.dollar
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun BankHomeScreen(balance: String?, name: String, id: Long) {
    var displayStatement by remember { mutableStateOf(false) }
    var actualDisplayStatement by remember { mutableStateOf(false) }
    val viewModel = koinViewModel<BankHomeViewModel>()
    val bankStatementState by viewModel.bankStatement.collectAsState()
    var movements by remember { mutableStateOf<List<Moviment>>(emptyList()) }
    var error by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        viewModel.initWith(id.toInt())
    }

    LaunchedEffect(bankStatementState) {
        when (val result = bankStatementState) {
            is Result.Success -> {
                movements = result.data
            }

            is Result.Error -> {
                println("error")
                error = result.error.name
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppSurface)
            .statusBarsPadding()
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(AppBase),
            color = AppSurface,
            shape = RoundedCornerShape(
                bottomStart = 50.dp
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
        Column {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AppWhite),
            ) {
                Column {
                    Box(modifier = Modifier.fillMaxWidth().height(50.dp).background(AppSurface))
                    Box(modifier = Modifier.fillMaxWidth().height(51.dp).background(AppWhite))
                }
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent),
                    color = AppBase,
                    shape = RoundedCornerShape(
                        topEnd = 50.dp,
                        bottomEnd = 50.dp
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .height(101.dp)
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            modifier = Modifier.size(60.dp),
                            painter = painterResource(Res.drawable.dollar),
                            contentDescription = null,
                        )
                        Text("Statement", fontWeight = FontWeight.Bold, color = AppSurface)
                        var routate by remember { mutableStateOf(false) }
                        val rotationAngle by animateFloatAsState(
                            targetValue = if (routate) 180f else 0f,
                            label = "rotation"
                        )
                        FloatingActionButton(
                            modifier = Modifier.size(60.dp)
                                .border(10.dp, AppWhite.copy(alpha = 0.6f), CircleShape),
                            containerColor = AppSurface,
                            onClick = {
                                displayStatement = !displayStatement
                                routate = !routate
                            },
                            elevation = FloatingActionButtonDefaults.elevation(0.dp),
                            shape = CircleShape
                        ) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = "show statement",
                                modifier = Modifier.rotate(rotationAngle)
                            )
                        }
                    }

                }
            }
        }

        LaunchedEffect(displayStatement) {
            if (displayStatement) {
                actualDisplayStatement = true
            } else {
                delay(1000)
                actualDisplayStatement = false
            }
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(AppBase),
            color = AppWhite,
            shape = RoundedCornerShape(
                topStart = 50.dp,
            )
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(18.dp),
            ) {
                Row {
                    AnimatedVisibility(
                        visible = displayStatement,
                        exit = fadeOut(animationSpec = tween(800)),
                        enter = fadeIn(animationSpec = tween(800))
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                "Detail of movements",
                                fontWeight = FontWeight.Bold,
                                color = AppSurface
                            )
                            Spacer(modifier = Modifier.height(3.dp))
                            LazyColumn {
                                items(
                                    items = movements,
                                    key = { moviment -> moviment.id }
                                ) { moviment ->
                                    StatementCard(moviment)
                                }
                                item {
                                    Spacer(modifier = Modifier.height(10.dp))
                                }
                            }
                        }
                    }
                }
                AnimatedVisibility(
                    visible = !displayStatement,
                    exit = fadeOut(animationSpec = tween(1000)),
                    enter = fadeIn(animationSpec = tween(1000))
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                            .padding(start = 18.dp),
                    ) {
                        ButtonsBlock()
                        Spacer(modifier = Modifier.height(6.dp))
                        BottomScreen(movements)
                    }
                }
            }
        }
    }
}
