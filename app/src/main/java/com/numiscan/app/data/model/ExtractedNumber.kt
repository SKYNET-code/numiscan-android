package com.numiscan.app.data.model

data class ExtractedNumber(

    val value: String,

    val type: NumberType,

    val selected: Boolean = false

)
