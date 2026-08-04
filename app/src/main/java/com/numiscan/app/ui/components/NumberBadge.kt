package com.numiscan.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.NumberType

@Composable
fun NumberBadge(

    type: NumberType

) {

    val title = when (type) {

        NumberType.MOBILE ->
            "موبایل"

        NumberType.LANDLINE ->
            "ثابت"

        NumberType.BANK_CARD ->
            "کارت بانکی"

        NumberType.SHABA ->
            "شبا"

        NumberType.GENERAL ->
            "عدد"

    }


    Text(

        text = title,

        style = MaterialTheme.typography.labelMedium,

        color = MaterialTheme.colorScheme.onPrimaryContainer,

        modifier = Modifier

            .clip(

                RoundedCornerShape(50)

            )

            .background(

                MaterialTheme.colorScheme.primaryContainer

            )

            .padding(

                horizontal = 12.dp,

                vertical = 5.dp

            )

    )

}
