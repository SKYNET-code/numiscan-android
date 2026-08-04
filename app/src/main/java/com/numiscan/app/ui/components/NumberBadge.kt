package com.numiscan.app.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.NumberType


@Composable
fun NumberBadge(

    type: NumberType

) {


    AssistChip(

        onClick = {},

        label = {

            Text(

                when(type){

                    NumberType.MOBILE ->
                        "موبایل"


                    NumberType.LANDLINE ->
                        "تلفن ثابت"


                    NumberType.BANK_CARD ->
                        "کارت بانکی"


                    NumberType.UNKNOWN ->
                        "نامشخص"

                }

            )

        }

    )

}
