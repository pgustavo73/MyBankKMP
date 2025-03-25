package com.pgustavo.mybank.app

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.pgustavo.mybank.bank.presentation.bank_home.BankHomeScreen
import com.pgustavo.mybank.bank.presentation.bank_login.BankLoginScreen
import com.pgustavo.mybank.core.presentation.Theme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    Theme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Route.BankGraph
        ) {
            navigation<Route.BankGraph>(
                startDestination = Route.BankLogin
            ) {
                composable<Route.BankLogin>(
                    exitTransition = { slideOutHorizontally() },
                    popEnterTransition = { slideInHorizontally() }
                ) {
                    BankLoginScreen { balance, name ->
                        navController.navigate(Route.BankHome(balance, name))
                    }
                }
                composable<Route.BankHome>(
                    enterTransition = { slideInHorizontally() },
                    exitTransition = { slideOutHorizontally() },
                    popEnterTransition = { slideInHorizontally() },
                    popExitTransition = { slideOutHorizontally() }
                ) {
                    val bankHome = it.toRoute<Route.BankHome>()
                    BankHomeScreen(bankHome.balance, bankHome.name)
                }
            }
        }
    }
}
