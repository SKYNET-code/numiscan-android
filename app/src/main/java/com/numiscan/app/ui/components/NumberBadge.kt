package com.numiscan.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.AssistChip
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.NumberType

@Composable
fun NumberBadge(

    type: NumberType

) {

    val text: String
    val color: Color

    when (type) {

        NumberType.MOBILE -> {

            text = "موبایل"
            color = Color(0xFF2E7D32)

        }

        NumberType.LANDLINE -> {

            text = "ثابت"
            color = Color(0xFF1565C0)

        }

        NumberType.BANK_CARD -> {

            text = "کارت"
            color = Color(0xFFEF6C00)

        }

        NumberType.SHABA -> {

            text = "شبا"
            color = Color(0xFF6A1B9A)

        }

    }

    Surface(

        color = color.copy(alpha = 0.15f),

        shape = RoundedCornerShape(50)

    ) {

        Text(

            text = text,

            color = color,

            style = MaterialTheme.typography.labelMedium,

            modifier = androidx.compose.ui.Modifier
                .height(32.dp),

        )

    }

}
