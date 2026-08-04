package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ClearAll
import androidx.compose.material.icons.outlined.DoneAll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ResultToolbar(

    selectedCount: Int,

    totalCount: Int,

    onSelectAll: () -> Unit,

    onClear: () -> Unit

) {

    ElevatedCard(

        modifier = Modifier.fillMaxWidth(),

        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 2.dp
        )

    ) {

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),

            verticalAlignment = Alignment.CenterVertically

        ) {

            Column(

                modifier = Modifier.weight(1f)

            ) {

                Text(

                    text = "نتایج استخراج",

                    style = MaterialTheme.typography.titleMedium

                )

                Text(

                    text = "$selectedCount انتخاب شده از $totalCount",

                    style = MaterialTheme.typography.bodySmall,

                    color = MaterialTheme.colorScheme.onSurfaceVariant

                )

            }

            FilledTonalIconButton(

                onClick = onSelectAll

            ) {

                Icon(

                    Icons.Outlined.DoneAll,

                    contentDescription = null

                )

            }

            Spacer(

                Modifier.width(8.dp)

            )

            FilledTonalIconButton(

                onClick = onClear

            ) {

                Icon(

                    Icons.Outlined.ClearAll,

                    contentDescription = null

                )

            }

        }

    }

}
