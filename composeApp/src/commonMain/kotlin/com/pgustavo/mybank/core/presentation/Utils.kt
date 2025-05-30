package com.pgustavo.mybank.core.presentation


import com.pgustavo.mybank.bank.domain.Moviment
import com.pgustavo.mybank.bank.domain.MovimentType
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime


fun formatCpf(input: String): String {
    val digits = input.filter { it.isDigit() }

    return buildString {
        for (i in digits.indices) {
            append(digits[i])
            if (i == 2 || i == 5) append('.')
            if (i == 8) append('-')
        }
    }
}

fun formatCurrency(amount: Double): String {
    val formatted = amount
        .toString()
        .split(".")
        .let { parts ->
            val integerPart = parts[0].reversed().chunked(3).joinToString(",").reversed()
            val decimalPart = parts.getOrNull(1)?.padEnd(2, '0') ?: "00"
            "$$integerPart.$decimalPart"
        }
    return formatted
}

fun cleanCpf(input: String): String {
    val clearCpf = input.replace(".", "").replace("-", "")
    return clearCpf
}



fun sumIncome(moviments: List<Moviment>): String {
    val inTotal = moviments
        .filter { it.movimentType == MovimentType.INCOME }
        .sumOf { it.value }
    return formatCurrency(inTotal)
}

fun sumExpense(moviments: List<Moviment>): String {
    val exTotal = moviments
        .filter { it.movimentType == MovimentType.EXPENSE }
        .sumOf { it.value }
    return formatCurrency(exTotal)
}

fun formatDate(isoString: String): String {
    val fixedIso = sanitizeIsoString(isoString)
    val instant = Instant.parse(fixedIso)
    val dateTime = instant.toLocalDateTime(TimeZone.UTC)

    val monthName = dateTime.month.name.lowercase().replaceFirstChar { it.uppercase() }
    return "$monthName ${dateTime.dayOfMonth},${dateTime.year}"
}

fun sanitizeIsoString(input: String): String {
    val withMilliseconds = input
        .replace(Regex("""\.(\d{3})\d*"""), ".$1")
        .let { if (!it.endsWith("Z")) it + "Z" else it }
    return withMilliseconds
}