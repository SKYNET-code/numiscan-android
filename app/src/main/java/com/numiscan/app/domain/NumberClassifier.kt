package com.numiscan.app.domain


import com.numiscan.app.data.model.NumberType



object NumberClassifier {


    fun classify(
        value: String
    ): NumberType {


        val number =
            value.trim()


        return when {


            number.startsWith("IR")
                    &&
                    number.length == 26 ->
                NumberType.SHABA



            number.length == 16
                    &&
                    number.all {
                        it.isDigit()
                    } ->
                NumberType.BANK_CARD



            number.startsWith("09")
                    &&
                    number.length == 11 ->
                NumberType.MOBILE



            number.startsWith("0")
                    &&
                    number.length >= 10 ->
                NumberType.LANDLINE



            else ->
                NumberType.UNKNOWN


        }


    }


}
