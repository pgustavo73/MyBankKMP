package com.pgustavo.mybank.bank.presentation.bank_login

sealed class BankLoginEvent {
    data class Login(val password: String) : BankLoginEvent()

    data object InvalidPassword : BankLoginEvent()

}
