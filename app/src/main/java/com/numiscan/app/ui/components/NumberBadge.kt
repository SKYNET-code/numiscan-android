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

    val text =
        when (type) {

            NumberType.MOBILE ->
                "موبایل"

            NumberType.LANDLINE ->
                "ثابت"

            NumberType.BANK_CARD ->
                "کارت"

            NumberType.SHABA ->
                "شبا"

        }

    Text(

        text = text,

        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(
                MaterialTheme.colorScheme.secondaryContainer
            )
            .padding(
                horizontal = 10.dp,
                vertical = 4.dp
            ),

        style = MaterialTheme.typography.labelMedium

    )

}
