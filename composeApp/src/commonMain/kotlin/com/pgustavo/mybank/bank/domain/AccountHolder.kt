package com.pgustavo.mybank.bank.domain

import kotlinx.serialization.Serializable

@Serializable
data class AccountHolder(
    val id: Long,
    val name: String,
    val cpf: String,
    val password: String,
    val number: String,
    val balance: Double?
)
