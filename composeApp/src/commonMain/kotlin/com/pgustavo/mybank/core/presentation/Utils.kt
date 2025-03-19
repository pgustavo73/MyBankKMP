package com.pgustavo.mybank.core.presentation

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

fun cleanCpf(input: String): String {
    val clearCpf = input.replace(".", "").replace("-", "")
    return clearCpf
}