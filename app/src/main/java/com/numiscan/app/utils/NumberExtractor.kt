package com.numiscan.app.utils

import com.numiscan.app.data.model.ExtractedNumber
import com.numiscan.app.data.model.NumberType

object NumberExtractor {

    fun extract(text: String): List<ExtractedNumber> {

        val normalized = normalizeDigits(text)

        val results = mutableListOf<ExtractedNumber>()

        Regex("\\bIR\\d{24}\\b", RegexOption.IGNORE_CASE)
            .findAll(normalized)
            .forEach { match ->
                results.add(
                    ExtractedNumber(
                        value = match.value.uppercase(),
                        type = NumberType.SHABA
                    )
                )
            }

        Regex("\\b\\d{16}\\b")
            .findAll(normalized)
            .forEach { match ->
                results.add(
                    ExtractedNumber(
                        value = match.value,
                        type = NumberType.BANK_CARD
                    )
                )
            }

        Regex("\\b09\\d{9}\\b")
            .findAll(normalized)
            .forEach { match ->
                results.add(
                    ExtractedNumber(
                        value = match.value,
                        type = NumberType.MOBILE
                    )
                )
            }

        Regex("\\b0[1-8]\\d{8,10}\\b")
            .findAll(normalized)
            .forEach { match ->

                val value = match.value

                if (!value.startsWith("09")) {
                    results.add(
                        ExtractedNumber(
                            value = value,
                            type = NumberType.LANDLINE
                        )
                    )
                }
            }

        return results.distinctBy { it.value }
    }

    private fun normalizeDigits(text: String): String {

        return text
            .replace('۰', '0')
            .replace('۱', '1')
            .replace('۲', '2')
            .replace('۳', '3')
            .replace('۴', '4')
            .replace('۵', '5')
            .replace('۶', '6')
            .replace('۷', '7')
            .replace('۸', '8')
            .replace('۹', '9')
            .replace('٠', '0')
            .replace('١', '1')
            .replace('٢', '2')
            .replace('٣', '3')
            .replace('٤', '4')
            .replace('٥', '5')
            .replace('٦', '6')
            .replace('٧', '7')
            .replace('٨', '8')
            .replace('٩', '9')
    }
}
