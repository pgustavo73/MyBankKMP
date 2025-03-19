package com.pgustavo.mybank.bank.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pgustavo.mybank.bank.data.repository.BankRepository
import com.pgustavo.mybank.bank.domain.AccountHolder
import com.pgustavo.mybank.bank.domain.Moviment
import com.pgustavo.mybank.core.domain.DataError
import com.pgustavo.mybank.core.domain.Result
import com.pgustavo.mybank.core.domain.onError
import com.pgustavo.mybank.core.domain.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModel(private val repository: BankRepository) : ViewModel() {

    private val _bankStatement = MutableStateFlow<Result<List<Moviment>, DataError.Remote>>(
        Result.Success(emptyList())
    )
    val bankStatement: StateFlow<Result<List<Moviment>, DataError.Remote>> = _bankStatement

    private val _accountHolder = MutableStateFlow<Result<AccountHolder, DataError.Remote>>(
        Result.Success(AccountHolder(0, "", "", "", null))
    )
    val accountHolder: StateFlow<Result<AccountHolder, DataError.Remote>> = _accountHolder

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        getAccountHolder("102560")
        findBankStatement(1)
    }

    private fun findBankStatement(accountId: Int) {
        viewModelScope.launch {
            repository.findBankStatement(accountId)
                .onSuccess {
                    _bankStatement.value = Result.Success(it)
                }
                .onError {
                    _bankStatement.value = Result.Error(it)
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
}