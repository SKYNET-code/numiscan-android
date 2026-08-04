package com.numiscan.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(

    primary = Primary,

    primaryContainer = PrimaryContainer,

    secondary = Secondary,

    background = Background,

    surface = Surface,

    surfaceVariant = SurfaceVariant,

    onPrimary = OnPrimary,

    onBackground = OnBackground,

    onSurface = OnSurface,

    outline = Outline

)

@Composable
fun NumiScanTheme(

    content: @Composable () -> Unit

) {

    MaterialTheme(

        colorScheme = LightColors,

        typography = Typography,

        shapes = Shapes,

        content = content

    )

}
