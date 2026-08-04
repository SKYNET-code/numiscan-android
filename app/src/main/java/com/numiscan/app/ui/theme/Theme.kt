package com.numiscan.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


private val LightColors = lightColorScheme(

    primary = PrimaryBlue,

    secondary = SecondaryTeal,

    background = BackgroundLight

)


private val DarkColors = darkColorScheme(

    primary = PrimaryBlue,

    secondary = SecondaryTeal,

    background = BackgroundDark

)



@Composable
fun NumiScanTheme(

    darkTheme: Boolean = isSystemInDarkTheme(),

    content: @Composable () -> Unit

) {

    MaterialTheme(

        colorScheme = if (darkTheme)
            DarkColors
        else
            LightColors,

        typography = AppTypography,

        content = content

    )

}
