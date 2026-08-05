package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(

    text: String,

    onClick: () -> Unit,

    modifier: Modifier = Modifier,

    outlined: Boolean = false

) {

    val shape = RoundedCornerShape(14.dp)

    if (outlined) {

        OutlinedButton(

            onClick = onClick,

            modifier = modifier
                .defaultMinSize(
                    minWidth = 170.dp,
                    minHeight = 48.dp
                ),

            shape = shape

        ) {

            Text(

                text = text,

                style = MaterialTheme.typography.titleMedium,

                maxLines = 1,

                softWrap = false,

                overflow = TextOverflow.Ellipsis

            )

        }

    } else {

        Button(

            onClick = onClick,

            modifier = modifier
                .defaultMinSize(
                    minWidth = 170.dp,
                    minHeight = 48.dp
                ),

            shape = shape

        ) {

            Text(

                text = text,

                style = MaterialTheme.typography.titleMedium,

                maxLines = 1,

                softWrap = false,

                overflow = TextOverflow.Ellipsis

            )

        }

    }

}
