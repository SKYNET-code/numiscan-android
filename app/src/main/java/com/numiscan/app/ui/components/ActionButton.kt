package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ActionButton(

    text: String,

    icon: ImageVector,

    onClick: () -> Unit

) {

    TextButton(

        onClick = onClick

    ) {

        Column(

            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Icon(

                imageVector = icon,

                contentDescription = null

            )

            Spacer(

                modifier = Modifier.height(4.dp)

            )

            Text(

                text = text,

                style = MaterialTheme.typography.labelMedium

            )

        }

    }

}
