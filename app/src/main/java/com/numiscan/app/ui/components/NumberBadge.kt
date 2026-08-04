package com.numiscan.app.ui.components


import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.numiscan.app.data.model.NumberType



@Composable
fun NumberBadge(

    type: NumberType

){


    val text = when(type){


        NumberType.MOBILE ->
            "موبایل"


        NumberType.LANDLINE ->
            "تلفن ثابت"


        NumberType.BANK_CARD ->
            "کارت بانکی"


        NumberType.SHABA ->
            "شبا"


        NumberType.UNKNOWN ->
            "نامشخص"


    }



    AssistChip(

        onClick = {},

        label = {

            Text(text)

        }

    )


}
