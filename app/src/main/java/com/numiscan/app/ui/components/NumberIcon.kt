package com.numiscan.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.PhoneAndroid
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.numiscan.app.data.model.NumberType

@Composable
fun NumberIcon(
    type: NumberType
) {

    val icon =
        when (type) {

            NumberType.MOBILE ->
                Icons.Outlined.PhoneAndroid

            NumberType.LANDLINE ->
                Icons.Outlined.Call

            NumberType.BANK_CARD ->
                Icons.Outlined.CreditCard

            NumberType.SHABA ->
                Icons.Outlined.AccountBalance

        }

    Icon(

        imageVector = icon,

        contentDescription = null

    )

}
