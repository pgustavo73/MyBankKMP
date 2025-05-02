package com.pgustavo.mybank.bank.data.network

import com.pgustavo.mybank.bank.domain.AccountHolder
import com.pgustavo.mybank.core.data.safeCall
import com.pgustavo.mybank.core.domain.DataError
import com.pgustavo.mybank.core.domain.Result
import com.pgustavo.mybank.bank.domain.Moviment
import io.ktor.client.HttpClient
import io.ktor.client.request.get


private const val BASE_URL = "http://192.168.0.10:8080"

class KtorRemoteDataSource(private val  httpClient: HttpClient) : RemoteDataSource {

    override suspend fun findBankStatement(accountId: Int): Result<List<Moviment>, DataError.Remote> {
        return safeCall<List<Moviment>> {
            httpClient.get(
                urlString = "$BASE_URL/moviments/$accountId"
            )
        }
    }

    override suspend fun gettAccountHolder(passWord: String): Result<AccountHolder, DataError.Remote> {
        return safeCall<AccountHolder> {
            httpClient.get(
                urlString = "$BASE_URL/accountHolders/$passWord"
            )
        }
    }

}