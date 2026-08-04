package com.numiscan.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.numiscan.app.data.model.NumberType

@Composable
fun NumberBadge(

    type: NumberType

) {

    val background: Color
    val foreground: Color
    val text: String

    when (type) {

        NumberType.MOBILE -> {

            background = Color(0xFFE8F5E9)
            foreground = Color(0xFF2E7D32)
            text = "موبایل"

        }

        NumberType.LANDLINE -> {

            background = Color(0xFFE3F2FD)
            foreground = Color(0xFF1565C0)
            text = "تلفن ثابت"

        }

        NumberType.BANK_CARD -> {

            background = Color(0xFFFFF3E0)
            foreground = Color(0xFFEF6C00)
            text = "کارت بانکی"

        }

        NumberType.SHABA -> {

            background = Color(0xFFF3E5F5)
            foreground = Color(0xFF7B1FA2)
            text = "شماره شبا"

        }

    }

    Row(

        modifier = Modifier
            .background(
                background,
                RoundedCornerShape(50.dp)
            )
            .padding(
                horizontal = 12.dp,
                vertical = 6.dp
            )

    ) {

        Text(

            text = text,

            color = foreground,

            fontSize = 12.sp,

            fontWeight = FontWeight.SemiBold

        )

    }

}
