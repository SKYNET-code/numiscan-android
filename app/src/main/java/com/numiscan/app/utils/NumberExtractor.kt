package com.numiscan.app.utils

import com.numiscan.app.data.model.ExtractedNumber
import com.numiscan.app.data.model.NumberType
import com.numiscan.app.domain.TextNormalizer

object NumberExtractor {

    fun extract(text: String): List<ExtractedNumber> {

        val normalized = TextNormalizer.normalize(text)

        val results = mutableListOf<ExtractedNumber>()

        extractShaba(normalized, results)
        extractBankCards(normalized, results)
        extractMobiles(normalized, results)
        extractLandlines(normalized, results)

        return results
            .distinctBy { "${it.type}:${it.value}" }
            .sortedBy { it.value }
    }

    private fun extractShaba(
        text: String,
        results: MutableList<ExtractedNumber>
    ) {

        Regex(
            "IR\\s*\\d(?:[\\s-]?\\d){25}",
            RegexOption.IGNORE_CASE
        ).findAll(text).forEach {

            val value =
                it.value
                    .replace(" ", "")
                    .replace("-", "")
                    .uppercase()

            if (value.length == 26) {

                results.add(
                    ExtractedNumber(
                        value = value,
                        type = NumberType.SHABA
                    )
                )
            }
        }
    }

    private fun extractBankCards(
        text: String,
        results: MutableList<ExtractedNumber>
    ) {

        Regex("\\d(?:[\\s-]?\\d){15}")
            .findAll(text)
            .forEach {

                val value =
                    it.value
                        .replace(" ", "")
                        .replace("-", "")

                if (value.length == 16) {

                    results.add(
                        ExtractedNumber(
                            value = value,
                            type = NumberType.BANK_CARD
                        )
                    )
                }
            }
    }

    private fun extractMobiles(
        text: String,
        results: MutableList<ExtractedNumber>
    ) {

        Regex("09\\d{9}")
            .findAll(text)
            .forEach {

                results.add(
                    ExtractedNumber(
                        value = it.value,
                        type = NumberType.MOBILE
                    )
                )
            }
    }

    private fun extractLandlines(
        text: String,
        results: MutableList<ExtractedNumber>
    ) {

        Regex("0[1-8]\\d{8,10}")
            .findAll(text)
            .forEach {

                if (!it.value.startsWith("09")) {

                    results.add(
                        ExtractedNumber(
                            value = it.value,
                            type = NumberType.LANDLINE
                        )
                    )
                }
            }
    }
}
