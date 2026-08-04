package com.numiscan.app.domain

import com.numiscan.app.data.model.ExtractedNumber


enum class SortType {

    ASCENDING,

    DESCENDING

}



class ResultSorter {


    fun sort(

        items: List<ExtractedNumber>,

        type: SortType

    ): List<ExtractedNumber> {


        return when(type) {


            SortType.ASCENDING ->

                items.sortedBy {

                    it.value

                }



            SortType.DESCENDING ->

                items.sortedByDescending {

                    it.value

                }

        }

    }

}
