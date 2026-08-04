package com.numiscan.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(

    primary = BluePrimary,

    secondary = BlueSecondary,

    background = LightBackground,

    surface = LightSurface

)


private val DarkColors = darkColorScheme(

    primary = BluePrimary,

    secondary = BlueSecondary,

    background = DarkBackground,

    surface = DarkSurface

)


@Composable
fun NumiScanTheme(

    darkTheme: Boolean = isSystemInDarkTheme(),

    content: @Composable () -> Unit

) {

    MaterialTheme(

        colorScheme = if (darkTheme) DarkColors else LightColors,

        typography = AppTypography,

        shapes = AppShapes,

        content = content

    )

}
