package com.numiscan.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import android.app.Activity


private val LightColors = lightColorScheme(

    primary = BluePrimary,
    secondary = BlueSecondary,

    background = LightBackground,
    surface = LightSurface,

    surfaceVariant = LightSurfaceVariant,

    outline = LightOutline

)


private val DarkColors = darkColorScheme(

    primary = DarkPrimary,
    secondary = DarkSecondary,

    background = DarkBackground,
    surface = DarkSurface,

    surfaceVariant = DarkSurfaceVariant,

    outline = DarkOutline

)


@Composable
fun NumiScanTheme(

    darkTheme: Boolean = isSystemInDarkTheme(),

    content: @Composable () -> Unit

) {

    val view = LocalView.current

    if (!view.isInEditMode) {

        val window = (view.context as Activity).window

        WindowCompat.getInsetsController(
            window,
            view
        ).isAppearanceLightStatusBars = !darkTheme


        window.statusBarColor =
            if (darkTheme) {
                DarkBackground.toArgb()
            } else {
                LightBackground.toArgb()
            }

    }


    MaterialTheme(

        colorScheme = if (darkTheme) {
            DarkColors
        } else {
            LightColors
        },

        typography = AppTypography,

        shapes = AppShapes,

        content = content

    )

}
