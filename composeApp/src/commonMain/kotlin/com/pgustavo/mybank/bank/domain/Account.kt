package com.pgustavo.mybank.bank.domain

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Serializable
data class Account @OptIn(ExperimentalUuidApi::class) constructor(
    @Contextual val number: Uuid?,
    val balance: Double?
)
