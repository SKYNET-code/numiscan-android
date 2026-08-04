package com.numiscan.app.domain

import com.numiscan.app.data.model.ExtractedNumber


class NumberExtractor {


    private val classifier = NumberClassifier()



    fun extract(text: String): List<ExtractedNumber> {


        val regex = Regex(
            "(09\\d{9}|\\d{11}|\\d{16})"
        )


        return regex
            .findAll(text)
            .map {


                val number = it.value


                ExtractedNumber(

                    value = number,

                    type = classifier.classify(number),

                    sourceText = it.value

                )


            }
            .toList()

    }

}
