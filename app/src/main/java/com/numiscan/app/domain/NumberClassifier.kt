package com.numiscan.app.domain

import com.numiscan.app.data.model.NumberType


class NumberClassifier {


    fun classify(number: String): NumberType {


        val clean = number
            .replace(" ", "")
            .replace("-", "")


        return when {


            clean.matches(
                Regex("^09\\d{9}$")
            ) -> {

                NumberType.MOBILE

            }


            clean.matches(
                Regex("^\\d{11}$")
            ) -> {

                NumberType.LANDLINE

            }


            clean.matches(
                Regex("^\\d{16}$")
            ) -> {

                NumberType.BANK_CARD

            }


            else -> {

                NumberType.UNKNOWN

            }

        }

    }

}
