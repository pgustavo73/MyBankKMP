package com.pgustavo.mybank.bank.presentation.bank_login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pgustavo.mybank.bank.data.repository.BankRepository
import com.pgustavo.mybank.bank.domain.AccountHolder
import com.pgustavo.mybank.bank.presentation.bank_login.components.BankLoginEvent
import com.pgustavo.mybank.core.domain.DataError
import com.pgustavo.mybank.core.domain.Result
import com.pgustavo.mybank.core.domain.onError
import com.pgustavo.mybank.core.domain.onSuccess
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BankLoginViewModel(private val repository: BankRepository) : ViewModel() {

    private val initialAccountHolder =
        Result.Success(AccountHolder(0, "", "", "", null))

    private val _accountHolder = MutableStateFlow<Result<AccountHolder, DataError.Remote>>(
        initialAccountHolder
    )
    val accountHolder: StateFlow<Result<AccountHolder, DataError.Remote>> = _accountHolder
    private val _events = MutableSharedFlow<BankLoginEvent>()

    init {
        handleEvents()
    }

    private fun handleEvents() {
        viewModelScope.launch {
            _events.collect { event ->
                when (event) {
                    is BankLoginEvent.Login -> getAccountHolder(event.password)
                    is BankLoginEvent.InvalidPassword ->
                        _accountHolder.value = initialAccountHolder
                }
            }
        }
    }

    private fun getAccountHolder(passWord: String) {
        viewModelScope.launch {
            repository.getAccountHolder(passWord)
                .onSuccess {
                    _accountHolder.value = Result.Success(it)
                }
                .onError {
                    _accountHolder.value = Result.Error(it)
                }
        }
    }

    fun login(event: BankLoginEvent) {
        viewModelScope.launch {
            _events.emit(event)
        }
    }

    fun clearAccountHolderData(event: BankLoginEvent) {
        viewModelScope.launch {
            _events.emit(event)
        }
    }
}
