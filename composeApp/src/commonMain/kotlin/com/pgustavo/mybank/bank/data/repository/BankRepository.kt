package com.pgustavo.mybank.bank.data.repository

import com.pgustavo.mybank.bank.domain.AccountHolder
import com.pgustavo.mybank.bank.domain.Moviment
import com.pgustavo.mybank.core.domain.DataError
import com.pgustavo.mybank.core.domain.Result

interface BankRepository {
    suspend fun findBankStatement(accountId: Int): Result<List<Moviment>, DataError.Remote>

    suspend fun getAccountHolder(passWord: String): Result<AccountHolder, DataError.Remote>
}