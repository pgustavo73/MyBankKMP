package com.pgustavo.mybank.bank.presentation.bank_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pgustavo.mybank.bank.data.repository.BankRepository
import com.pgustavo.mybank.bank.domain.Moviment
import com.pgustavo.mybank.core.domain.DataError
import com.pgustavo.mybank.core.domain.Result
import com.pgustavo.mybank.core.domain.onError
import com.pgustavo.mybank.core.domain.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BankHomeViewModel(private val repository: BankRepository) : ViewModel() {

    private val _bankStatement = MutableStateFlow<Result<List<Moviment>, DataError.Remote>>(
        Result.Success(emptyList())
    )
    val bankStatement: StateFlow<Result<List<Moviment>, DataError.Remote>> = _bankStatement


    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private var hasInitialized = false

    fun initWith(accountId: Int) {
        if (hasInitialized) return
        hasInitialized = true
        loadBankStatement(accountId)
    }


    private fun loadBankStatement(accountId: Int) {
        viewModelScope.launch {
            repository.findBankStatement(accountId)
                .onSuccess {
                    _bankStatement.value = Result.Success(it)
                }
                .onError {
                    _bankStatement.value = Result.Error(it)
                    _error.value = "Could not load statement"
                }
        }
    }
}