package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
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

    outlined: Boolean = false

) {

    if (outlined) {

        OutlinedButton(

            onClick = onClick,

            modifier = modifier
                .fillMaxWidth()
                .defaultMinSize(
                    minHeight = 48.dp
                ),

            shape = RoundedCornerShape(12.dp)

        ) {

            Text(

                text = text,

                maxLines = 1,

                style = MaterialTheme.typography.titleMedium

            )

        }

    } else {

        Button(

            onClick = onClick,

            modifier = modifier
                .fillMaxWidth()
                .defaultMinSize(
                    minHeight = 48.dp
                ),

            shape = RoundedCornerShape(12.dp),

            colors = ButtonDefaults.buttonColors(

                containerColor = MaterialTheme.colorScheme.primary,

                contentColor = MaterialTheme.colorScheme.onPrimary

            )

        ) {

            Text(

                text = text,

                maxLines = 1,

                style = MaterialTheme.typography.titleMedium

            )

        }

    }

}
