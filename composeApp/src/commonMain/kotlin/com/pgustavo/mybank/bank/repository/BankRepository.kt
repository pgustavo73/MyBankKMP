package com.pgustavo.mybank.bank.repository

import com.pgustavo.mybank.bank.domain.Moviment
import com.pgustavo.mybank.core.domain.DataError
import com.pgustavo.mybank.core.domain.Result

interface BankRepository {
    suspend fun findBankStatement(accountId: Int): Result<List<Moviment>, DataError.Remote>
}