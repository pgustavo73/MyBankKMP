package com.pgustavo.mybank.bank.presentation

import androidx.lifecycle.ViewModel
import com.pgustavo.mybank.bank.domain.AccountHolder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class LogedAccountViewModel: ViewModel() {

    private val _logedAccount = MutableStateFlow<AccountHolder?>(null)
    val logedAccount = _logedAccount.asStateFlow()

    fun onLoginClick(accountHolder: AccountHolder?) {
        _logedAccount.value = accountHolder
    }
}