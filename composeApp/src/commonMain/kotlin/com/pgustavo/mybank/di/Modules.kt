package com.pgustavo.mybank.di


import com.pgustavo.mybank.bank.data.network.RemoteDataSource
import com.pgustavo.mybank.bank.data.network.KtorRemoteDataSource
import com.pgustavo.mybank.bank.data.repository.BankRepository
import com.pgustavo.mybank.bank.data.repository.BankRepositoryIml
import com.pgustavo.mybank.bank.presentation.bank_home.BankHomeViewModel
import com.pgustavo.mybank.bank.presentation.bank_login.BankLoginViewModel
import com.pgustavo.mybank.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::BankRepositoryIml).bind<BankRepository>()
    singleOf(::KtorRemoteDataSource).bind<RemoteDataSource>()

    viewModelOf(::BankHomeViewModel)
    viewModelOf(::BankLoginViewModel)

}