package com.pgustavo.mybank.app

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object BankGraph : Route

    @Serializable
    data class BankHome(val balance: String?, val  name: String, val id: Long) : Route

    @Serializable
    data object BankLogin : Route

}