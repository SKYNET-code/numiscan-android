package com.numiscan.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(

    primary = Primary,
    secondary = Secondary,
    tertiary = Accent,

    background = Background,
    surface = Surface,

    onPrimary = Surface,
    onBackground = TextPrimary,
    onSurface = TextPrimary

)

private val DarkColors = darkColorScheme(

    primary = Secondary,
    secondary = Accent,

    background = Color(0xFF111827),
    surface = Color(0xFF1F2937),

    onPrimary = Surface,
    onBackground = Surface,
    onSurface = Surface

)

@Composable
fun NumiScanTheme(

    darkTheme: Boolean = isSystemInDarkTheme(),

    content: @Composable () -> Unit

) {

    MaterialTheme(

        colorScheme = if (darkTheme) DarkColors else LightColors,

        typography = AppTypography,

        content = content

    )

}
