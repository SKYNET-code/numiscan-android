package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
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

    outlined: Boolean = true

) {

    OutlinedButton(

        onClick = onClick,

        modifier = modifier
            .wrapContentWidth()
            .defaultMinSize(
                minWidth = 220.dp,
                minHeight = 48.dp
            ),

        shape = RoundedCornerShape(12.dp),

        colors = ButtonDefaults.outlinedButtonColors(

            contentColor = MaterialTheme.colorScheme.primary

        ),

        border = ButtonDefaults.outlinedButtonBorder.copy(

            width = 1.4.dp

        )

    ) {

        Text(

            text = text,

            style = MaterialTheme.typography.titleMedium,

            color = MaterialTheme.colorScheme.primary

        )

    }

}
