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
        extractGeneralNumbers(normalized, results)

        return results
            .distinctBy { "${it.type}:${it.value}" }
            .sortedBy { it.value }

    }


    private fun extractShaba(
        text: String,
        results: MutableList<ExtractedNumber>
    ) {

        Regex(
            "(?<!\\d)IR\\s*\\d(?:[\\s-]?\\d){25}(?!\\d)",
            RegexOption.IGNORE_CASE
        )
            .findAll(text)
            .forEach {

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

        Regex(
            "(?<!\\d)\\d(?:[\\s-]?\\d){15}(?!\\d)"
        )
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

        Regex(
            "(?<!\\d)09\\d{9}(?!\\d)"
        )
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

        Regex(
            "(?<![\\d۰-۹])0[1-8]\\d{8,10}(?![\\d۰-۹])"
        )
            .findAll(text)
            .forEach {

                val value = it.value

                if (!value.startsWith("09")) {

                    results.add(
                        ExtractedNumber(
                            value = value,
                            type = NumberType.LANDLINE
                        )
                    )

                }

            }

    }


    private fun extractGeneralNumbers(
        text: String,
        results: MutableList<ExtractedNumber>
    ) {

        Regex(
            "(?<![\\d۰-۹])(?:[\\d۰-۹]+(?:[,،][\\d۰-۹]{3})*)(?![\\d۰-۹])"
        )
            .findAll(text)
            .forEach {

                val value =
                    it.value
                        .replace(",", "")
                        .replace("،", "")
                        .trim()

                if (
                    value.length >= 3 &&
                    !results.any { item ->
                        item.value == value
                    }
                ) {

                    results.add(
                        ExtractedNumber(
                            value = value,
                            type = NumberType.GENERAL
                        )
                    )

                }

            }

    }

}
