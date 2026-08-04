package com.numiscan.app.utils


object ExportManager {


    fun createTxtContent(

        numbers: List<String>

    ): String {


        return numbers.joinToString(
            separator = "\n"
        )

    }

}
