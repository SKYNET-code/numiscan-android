package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun SmallActionButton(

    icon: ImageVector,

    contentDescription: String? = null,

    onClick: () -> Unit,

    modifier: Modifier = Modifier

) {

    IconButton(

        onClick = onClick,

        modifier = modifier.size(40.dp)

    ) {

        Icon(

            imageVector = icon,

            contentDescription = contentDescription

        )

    }

}
