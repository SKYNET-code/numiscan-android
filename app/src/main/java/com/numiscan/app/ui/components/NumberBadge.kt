package com.numiscan.app.ui.components

import androidx.compose.material3.AssistChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.numiscan.app.data.model.NumberType

@Composable
fun NumberBadge(
    type: NumberType
) {

    val text = when (type) {
        NumberType.MOBILE -> "موبایل"
        NumberType.LANDLINE -> "تلفن"
        NumberType.BANK_CARD -> "کارت"
        NumberType.SHABA -> "شبا"
    }

    AssistChip(
        onClick = {},
        label = {
            Text(text)
        }
    )
}
