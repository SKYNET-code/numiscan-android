package com.numiscan.app.utils


import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.graphics.Color



object TextHighlighter {



    fun highlight(

        text: String,

        numbers: List<String>

    ): AnnotatedString {



        return buildAnnotatedString {



            append(text)



            numbers.forEach { number ->



                var start =
                    text.indexOf(number)



                while(start >= 0){



                    addStyle(

                        style =
                            SpanStyle(

                                color =
                                    Color.Blue

                            ),


                        start = start,


                        end =
                            start + number.length

                    )



                    start =
                        text.indexOf(

                            number,

                            start + 1

                        )

                }

            }

        }

    }

}
