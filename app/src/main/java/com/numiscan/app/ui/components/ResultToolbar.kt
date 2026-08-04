package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ClearAll
import androidx.compose.material.icons.outlined.DoneAll
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ResultToolbar(

    selectedCount: Int,

    totalCount: Int,

    onSelectAll: () -> Unit,

    onClear: () -> Unit

) {

    Row(

        modifier = Modifier.fillMaxWidth(),

        horizontalArrangement = Arrangement.spacedBy(12.dp)

    ) {

        FilledTonalButton(

            modifier = Modifier.weight(1f),

            onClick = onSelectAll

        ) {

            Icon(

                imageVector = Icons.Outlined.DoneAll,

                contentDescription = null

            )

            Text(

                text = " انتخاب همه"

            )

        }

        FilledTonalButton(

            modifier = Modifier.weight(1f),

            onClick = onClear

        ) {

            Icon(

                imageVector = Icons.Outlined.ClearAll,

                contentDescription = null

            )

            Text(

                text = " پاک کردن"

            )

        }

    }

    Text(

        text = "انتخاب شده: $selectedCount از $totalCount",

        style = MaterialTheme.typography.bodyMedium

    )

}
