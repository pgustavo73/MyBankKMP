package com.pgustavo.mybank.bank.repository

import com.pgustavo.mybank.bank.data.network.RemoteDataSource
import com.pgustavo.mybank.bank.domain.Moviment
import com.pgustavo.mybank.core.domain.DataError
import com.pgustavo.mybank.core.domain.Result

class BankRepositoryIml(private val remoteDataSource: RemoteDataSource) : BankRepository {
    override suspend fun findBankStatement(accountId: Int): Result<List<Moviment>, DataError.Remote> {
        return remoteDataSource.findBankStatement(accountId)
    }
}