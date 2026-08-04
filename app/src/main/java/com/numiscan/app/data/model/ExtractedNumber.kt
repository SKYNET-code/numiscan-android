package com.numiscan.app.data.model

import androidx.compose.runtime.Immutable

@Immutable
data class ExtractedNumber(

    val value: String,

    val type: NumberType,

    val selected: Boolean = false

)
