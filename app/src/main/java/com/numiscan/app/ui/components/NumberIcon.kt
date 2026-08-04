package com.numiscan.app.ui.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.numiscan.app.data.model.NumberType



@Composable
fun NumberIcon(

    type: NumberType

){


    Icon(

        imageVector = when(type){


            NumberType.MOBILE ->
                Icons.Default.PhoneAndroid


            NumberType.LANDLINE ->
                Icons.Default.Phone


            NumberType.BANK_CARD ->
                Icons.Default.CreditCard


            NumberType.UNKNOWN ->
                Icons.Default.QuestionMark

        },


        contentDescription = null

    )

}
