package com.numiscan.app.domain

import com.numiscan.app.data.model.ExtractedNumber

class DuplicateFilter {

    fun removeDuplicates(
        list: List<ExtractedNumber>
    ): List<ExtractedNumber> {

        return list.distinctBy { it.value }

    }

}
