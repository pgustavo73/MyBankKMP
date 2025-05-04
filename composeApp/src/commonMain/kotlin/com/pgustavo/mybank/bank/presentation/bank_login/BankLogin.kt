package com.pgustavo.mybank.bank.presentation.bank_login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import com.pgustavo.mybank.bank.presentation.components.CPFInputField
import com.pgustavo.mybank.bank.presentation.components.MyBottomSheet
import com.pgustavo.mybank.bank.presentation.components.PasswordInputField
import com.pgustavo.mybank.core.domain.Result
import com.pgustavo.mybank.core.presentation.AppWhite
import com.pgustavo.mybank.core.presentation.AppSurface
import com.pgustavo.mybank.core.presentation.cleanCpf
import com.pgustavo.mybank.core.presentation.formatCurrency
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun BankLoginScreen(onClick: (String, String, Long) -> Unit) {
    var cpf by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }
    val viewModel = koinViewModel<BankLoginViewModel>()
    val accountHolderState by viewModel.accountHolder.collectAsState()
    var loginAttempted by remember { mutableStateOf(false) }
    var showSheet by remember { mutableStateOf(false) }

    LaunchedEffect(accountHolderState) {
        if (loginAttempted) {
            when (val result = accountHolderState) {
                is Result.Success -> {
                    cpf = cleanCpf(cpf)
                    if (password == result.data.password &&
                        cpf == result.data.cpf
                    ) {
                        val balance = formatCurrency(result.data.balance ?: 0.0)
                        onClick(balance, result.data.name, result.data.id)
                    } else {
                        error = "Invalid password or cpf"
                    }
                }
                is Result.Error -> {
                    println("error")
                    error = result.error.name
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppSurface)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(AppWhite),
            color = AppSurface,
            shape = RoundedCornerShape(
                bottomEnd = 100.dp
            )
        ) {
            Text(
                modifier = Modifier.padding(100.dp),
                text = "My Bank", style = MaterialTheme.typography.displayLarge,
                color = AppWhite
            )
            Spacer(modifier = Modifier.height(50.dp))
        }
        Surface(
            modifier = Modifier
                .weight(1.8f)
                .fillMaxWidth()
                .background(AppSurface),
            color = AppWhite,
            shape = RoundedCornerShape(
                topStart = 100.dp
            )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                CPFInputField(
                    cpf = cpf,
                    onCpfChange = { cpf = it }
                )
                PasswordInputField(
                    password = password,
                    onPasswordChange = { password = it }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        error = ""
                        loginAttempted = true
                        viewModel.login(BankLoginEvent.Login(password))
                    },
                    enabled = cpf.isNotEmpty() && password.isNotEmpty()
                ) {
                    Text(text = "Login")
                }
                Spacer(modifier = Modifier.height(16.dp))

                if (error.isNotEmpty()) {
                    showSheet = true
                    MyBottomSheet(
                        showSheet = showSheet,
                        onDismiss = {
                            viewModel.clearAccountHolderData(BankLoginEvent.InvalidPassword)
                            error = ""
                            loginAttempted = false
                            cpf = ""
                            password = ""
                            showSheet = false
                        }
                    )
                }
            }
        }
    }
}
