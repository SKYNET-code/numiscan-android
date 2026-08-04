package com.numiscan.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.NumberType

@Composable
fun NumberBadge(
    type: NumberType
) {

    val (title, color) = when (type) {

        NumberType.MOBILE ->
            "موبایل" to Color(0xFF2E7D32)

        NumberType.LANDLINE ->
            "تلفن ثابت" to Color(0xFF1565C0)

        NumberType.BANK_CARD ->
            "کارت بانکی" to Color(0xFFF57C00)

        NumberType.SHABA ->
            "شماره شبا" to Color(0xFF6A1B9A)

    }

    Surface(

        color = color.copy(alpha = 0.12f),

        shape = RoundedCornerShape(50.dp)

    ) {

        Text(

            text = title,

            color = color,

            style = MaterialTheme.typography.labelMedium,

            modifier = Modifier.padding(
                horizontal = 12.dp,
                vertical = 6.dp
            )

        )

    }

}
