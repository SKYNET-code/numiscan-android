package com.numiscan.app.domain

import com.numiscan.app.data.model.ExtractedNumber

class DuplicateFilter {

    fun removeDuplicates(
        items: List<ExtractedNumber>
    ): List<ExtractedNumber> {

        return items
            .distinctBy { it.value.trim() }
    }
}
