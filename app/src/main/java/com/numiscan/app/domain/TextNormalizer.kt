package com.numiscan.app.domain

object TextNormalizer {

    private val persianDigits = charArrayOf(
        '۰','۱','۲','۳','۴','۵','۶','۷','۸','۹'
    )

    private val arabicDigits = charArrayOf(
        '٠','١','٢','٣','٤','٥','٦','٧','٨','٩'
    )

    fun normalize(text: String): String {

        var result = text

        persianDigits.forEachIndexed { index, c ->

            result = result.replace(c, ('0' + index))

        }

        arabicDigits.forEachIndexed { index, c ->

            result = result.replace(c, ('0' + index))

        }

        return result
            .replace("ي", "ی")
            .replace("ك", "ک")
            .replace("\u200C", "")
            .replace("\u200F", "")
            .replace("\u200E", "")
            .trim()

    }

}
