package com.pgustavo.mybank.bank.domain

import kotlinx.serialization.Serializable

@Serializable
data class Moviment(
    val id: Long,
    val dateTime: String? = null,
    val description: String,
    val value: Double,
    val movimentType: MovimentType? = null,
    val accountId: Int
)
