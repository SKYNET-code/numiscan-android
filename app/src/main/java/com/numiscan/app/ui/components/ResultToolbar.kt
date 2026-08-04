package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DeleteSweep
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ResultToolbar(

    onClear: () -> Unit,

    modifier: Modifier = Modifier

) {

    Row(

        modifier = modifier
            .fillMaxWidth(),

        horizontalArrangement = Arrangement.End,

        verticalAlignment = Alignment.CenterVertically

    ) {

        IconButton(

            onClick = onClear

        ) {

            Icon(

                imageVector = Icons.Outlined.DeleteSweep,

                contentDescription = "Clear",

                tint = MaterialTheme.colorScheme.primary

            )

        }

    }

}
