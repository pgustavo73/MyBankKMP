package com.pgustavo.mybank.bank.data.repository

import com.pgustavo.mybank.bank.data.network.RemoteDataSource
import com.pgustavo.mybank.bank.domain.AccountHolder
import com.pgustavo.mybank.bank.domain.Moviment
import com.pgustavo.mybank.core.domain.DataError
import com.pgustavo.mybank.core.domain.Result

class BankRepositoryIml(private val remoteDataSource: RemoteDataSource) : BankRepository {
    override suspend fun findBankStatement(accountId: Int): Result<List<Moviment>, DataError.Remote> {
        return remoteDataSource.findBankStatement(accountId)
    }

    override suspend fun getAccountHolder(passWord: String): Result<AccountHolder, DataError.Remote> {
        return  remoteDataSource.gettAccountHolder(passWord)
    }
}