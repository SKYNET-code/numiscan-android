package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ActionButton(

    icon: ImageVector,

    text: String,

    onClick: () -> Unit,

    modifier: Modifier = Modifier

) {

    Button(

        onClick = onClick,

        modifier = modifier

    ) {

        Row(

            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center

        ) {

            Icon(

                imageVector = icon,

                contentDescription = null

            )

            Spacer(

                modifier = Modifier.width(6.dp)

            )

            Text(

                text = text

            )

        }

    }

}
