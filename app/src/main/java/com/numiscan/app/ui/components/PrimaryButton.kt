package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(

    text: String,

    onClick: () -> Unit,

    modifier: Modifier = Modifier,

    outlined: Boolean = false,

    destructive: Boolean = false

) {

    val colors = when {

        destructive -> ButtonDefaults.buttonColors(

            containerColor = MaterialTheme.colorScheme.errorContainer,

            contentColor = MaterialTheme.colorScheme.onErrorContainer

        )

        else -> ButtonDefaults.buttonColors(

            containerColor = MaterialTheme.colorScheme.primary,

            contentColor = MaterialTheme.colorScheme.onPrimary

        )

    }

    if (outlined) {

        OutlinedButton(

            onClick = onClick,

            modifier = modifier
                .wrapContentWidth()
                .defaultMinSize(
                    minWidth = 160.dp,
                    minHeight = 50.dp
                ),

            shape = RoundedCornerShape(16.dp)

        ) {

            Text(

                text = text,

                style = MaterialTheme.typography.titleMedium,

                maxLines = 1

            )

        }

    } else {

        Button(

            onClick = onClick,

            modifier = modifier
                .wrapContentWidth()
                .defaultMinSize(
                    minWidth = 160.dp,
                    minHeight = 50.dp
                ),

            shape = RoundedCornerShape(16.dp),

            colors = colors

        ) {

            Text(

                text = text,

                style = MaterialTheme.typography.titleMedium,

                maxLines = 1

            )

        }

    }

}
