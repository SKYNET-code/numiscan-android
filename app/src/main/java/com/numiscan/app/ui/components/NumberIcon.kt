package com.numiscan.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.numiscan.app.data.model.NumberType

@Composable
fun NumberIcon(
    type: NumberType,
    contentDescription: String? = null
) {

    val image = when (type) {
        NumberType.MOBILE -> Icons.Default.PhoneAndroid
        NumberType.LANDLINE -> Icons.Default.Call
        NumberType.BANK_CARD -> Icons.Default.CreditCard
        NumberType.SHABA -> Icons.Default.AccountBalance
    }

    Icon(
        imageVector = image,
        contentDescription = contentDescription
    )
}
