package com.numiscan.app.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString


object TextHighlighter {


    fun highlight(

        text: String,

        numbers: List<String>

    ): AnnotatedString {


        return buildAnnotatedString {


            append(text)


            numbers.forEach { number ->


                addStringAnnotation(

                    tag = "NUMBER",

                    annotation = number,

                    start = text.indexOf(number),

                    end = text.indexOf(number)
                        + number.length

                )

            }

        }

    }

}
