package com.pgustavo.mybank.bank.domain

import kotlinx.serialization.Serializable

@Serializable
data class Moviment(
    val id: Long,
    val date: String? = null,
    val description: String,
    val value: Double,
    val type: MovimentType? = null,
    val accountId: Int
)
