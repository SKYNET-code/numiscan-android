package com.numiscan.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.PhoneAndroid
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.numiscan.app.data.model.NumberType

@Composable
fun NumberIcon(

    type:NumberType

){

    val icon:ImageVector=

        when(type){

            NumberType.MOBILE ->
                Icons.Outlined.PhoneAndroid

            NumberType.PHONE ->
                Icons.Outlined.Call

            NumberType.CARD ->
                Icons.Outlined.CreditCard

            NumberType.SHABA ->
                Icons.Outlined.AccountBalance

            NumberType.EMAIL ->
                Icons.Outlined.Email

            NumberType.URL ->
                Icons.Outlined.Language

            NumberType.UNKNOWN ->
                Icons.Outlined.HelpOutline

        }

    Icon(

        imageVector = icon,

        contentDescription = null

    )

}
