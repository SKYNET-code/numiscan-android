package com.numiscan.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import com.numiscan.app.data.model.NumberType

@Composable
fun NumberBadge(

    type: NumberType

) {

    val (title,color)=when(type){

        NumberType.MOBILE ->
            "موبایل" to Color(0xFF16A34A)

        NumberType.PHONE ->
            "تلفن ثابت" to Color(0xFFF59E0B)

        NumberType.CARD ->
            "کارت بانکی" to Color(0xFF2563EB)

        NumberType.SHABA ->
            "شبا" to Color(0xFF7C3AED)

        NumberType.EMAIL ->
            "ایمیل" to Color(0xFF0891B2)

        NumberType.URL ->
            "لینک" to Color(0xFF6B7280)

        NumberType.UNKNOWN ->
            "سایر" to Color(0xFF9CA3AF)

    }

    Surface(

        shape= RoundedCornerShape(50),

        color=color,

        contentColor= Color.White

    ){

        Text(

            text=title,

            modifier=Modifier.padding(

                horizontal =12.dp,

                vertical =6.dp

            ),

            style=MaterialTheme.typography.labelMedium

        )

    }

}
