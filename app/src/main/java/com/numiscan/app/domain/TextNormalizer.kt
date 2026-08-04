package com.numiscan.app.domain

object TextNormalizer {

    fun normalize(text: String): String {

        return buildString {

            text.forEach { c ->

                append(
                    when (c) {

                        in '۰'..'۹' ->
                            '0' + (c - '۰')

                        in '٠'..'٩' ->
                            '0' + (c - '٠')

                        'ي' -> 'ی'

                        'ك' -> 'ک'

                        '\u200C',
                        '\u200E',
                        '\u200F' -> ' '

                        else -> c

                    }
                )

            }

        }.replace(
            Regex("\\s+"),
            " "
        ).trim()

    }

}
