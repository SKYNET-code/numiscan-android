package com.numiscan.app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.numiscan.app.R

private val VazirFont = FontFamily(

    Font(
        R.font.vazirmatn_regular,
        FontWeight.Normal
    ),

    Font(
        R.font.vazirmatn_medium,
        FontWeight.Medium
    )

)

val Typography = Typography(

    bodyLarge = TextStyle(

        fontFamily = VazirFont,

        fontWeight = FontWeight.Normal,

        fontSize = 16.sp

    ),

    bodyMedium = TextStyle(

        fontFamily = VazirFont,

        fontWeight = FontWeight.Normal,

        fontSize = 14.sp

    ),

    bodySmall = TextStyle(

        fontFamily = VazirFont,

        fontWeight = FontWeight.Normal,

        fontSize = 12.sp

    ),

    titleLarge = TextStyle(

        fontFamily = VazirFont,

        fontWeight = FontWeight.Medium,

        fontSize = 22.sp

    ),

    titleMedium = TextStyle(

        fontFamily = VazirFont,

        fontWeight = FontWeight.Medium,

        fontSize = 18.sp

    ),

    titleSmall = TextStyle(

        fontFamily = VazirFont,

        fontWeight = FontWeight.Medium,

        fontSize = 16.sp

    ),

    labelLarge = TextStyle(

        fontFamily = VazirFont,

        fontWeight = FontWeight.Medium,

        fontSize = 14.sp

    ),

    labelMedium = TextStyle(

        fontFamily = VazirFont,

        fontWeight = FontWeight.Medium,

        fontSize = 12.sp

    ),

    labelSmall = TextStyle(

        fontFamily = VazirFont,

        fontWeight = FontWeight.Normal,

        fontSize = 11.sp

    )

)
