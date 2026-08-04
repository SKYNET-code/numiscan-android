package com.numiscan.app.utils


import com.numiscan.app.data.model.NumberItem
import com.numiscan.app.data.model.NumberType



object NumberExtractor {



    fun extract(text: String): List<NumberItem> {


        val normalized =
            normalizeDigits(text)


        val results =
            mutableListOf<NumberItem>()



        val shabaRegex =
            Regex(
                "\\bIR[0-9]{24}\\b",
                RegexOption.IGNORE_CASE
            )



        shabaRegex.findAll(normalized)
            .forEach {


                results.add(

                    ExtractedNumber(

                        value = it.value.uppercase(),

                        type = NumberType.SHABA

                    )

                )


            }



        val cardRegex =
            Regex("\\b[0-9]{16}\\b")



        cardRegex.findAll(normalized)
            .forEach {


                results.add(

                    ExtractedNumber(

                        value = it.value,

                        type = NumberType.BANK_CARD

                    )

                )


            }



        val mobileRegex =
            Regex(
                "\\b09[0-9]{9}\\b"
            )



        mobileRegex.findAll(normalized)
            .forEach {


                results.add(

                    ExtractedNumber(

                        value = it.value,

                        type = NumberType.MOBILE

                    )

                )


            }



        val phoneRegex =
            Regex(
                "\\b0[1-8][0-9]{8,10}\\b"
            )



        phoneRegex.findAll(normalized)
            .forEach {



                val value =
                    it.value



                if(
                    !value.startsWith("09")
                    &&
                    value.length >= 10
                ){


                    results.add(

                        ExtractedNumber(

                            value = value,

                            type = NumberType.LANDLINE

                        )

                    )

                }


            }



        return results
            .distinctBy {

                it.value

            }


    }





    private fun normalizeDigits(
        input: String
    ): String {


        return input

            .replace('۰','0')
            .replace('۱','1')
            .replace('۲','2')
            .replace('۳','3')
            .replace('۴','4')
            .replace('۵','5')
            .replace('۶','6')
            .replace('۷','7')
            .replace('۸','8')
            .replace('۹','9')

            .replace(
                Regex("\\s+"),
                " "
            )

    }


}
