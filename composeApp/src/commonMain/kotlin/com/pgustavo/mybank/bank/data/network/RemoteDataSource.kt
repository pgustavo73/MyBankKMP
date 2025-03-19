package com.pgustavo.mybank.bank.data.network

import com.pgustavo.mybank.bank.domain.AccountHolder
import com.pgustavo.mybank.bank.domain.Moviment
import com.pgustavo.mybank.core.domain.DataError
import com.pgustavo.mybank.core.domain.Result

interface RemoteDataSource {
    suspend fun findBankStatement(accountId: Int): Result<List<Moviment>, DataError.Remote>

    suspend fun gettAccountHolder(passWord: String): Result<AccountHolder, DataError.Remote>
}