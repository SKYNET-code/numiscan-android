package com.numiscan.app.domain

import com.numiscan.app.data.model.ExtractedNumber
import com.numiscan.app.data.model.NumberType


class ResultFilter {


    fun filter(

        items: List<ExtractedNumber>,

        query: String,

        type: NumberType?

    ): List<ExtractedNumber> {


        return items.filter { item ->


            val matchesQuery =
                query.isBlank() ||
                item.value.contains(query)



            val matchesType =
                type == null ||
                item.type == type



            matchesQuery && matchesType

        }

    }


}
