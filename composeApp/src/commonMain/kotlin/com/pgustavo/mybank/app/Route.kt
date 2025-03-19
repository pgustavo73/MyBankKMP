package com.pgustavo.mybank.app

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object BankGraph : Route

    @Serializable
    data class BankHome(val id: String, val  name: String) : Route

    @Serializable
    data object BankLogin : Route

}