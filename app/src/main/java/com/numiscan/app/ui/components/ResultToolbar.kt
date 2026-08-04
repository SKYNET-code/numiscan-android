package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ResultToolbar(

    selectedCount: Int,

    totalCount: Int,

    onSelectAll: () -> Unit,

    onClear: () -> Unit

) {

    Column(

        modifier = Modifier.fillMaxWidth(),

        verticalArrangement = Arrangement.spacedBy(12.dp)

    ) {

        Text(

            text = "نتایج استخراج",

            style = MaterialTheme.typography.titleLarge,

            fontWeight = FontWeight.Bold

        )

        Text(

            text = "$totalCount مورد پیدا شد",

            style = MaterialTheme.typography.bodyMedium,

            color = MaterialTheme.colorScheme.onSurfaceVariant

        )

        Row(

            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.spacedBy(10.dp)

        ) {

            OutlinedButton(

                modifier = Modifier.weight(1f),

                onClick = onSelectAll

            ) {

                Text("انتخاب همه")

            }

            OutlinedButton(

                modifier = Modifier.weight(1f),

                onClick = onClear

            ) {

                Text("پاک کردن")

            }

        }

        if (selectedCount > 0) {

            Text(

                text = "$selectedCount مورد انتخاب شده",

                style = MaterialTheme.typography.bodySmall,

                color = MaterialTheme.colorScheme.primary

            )

        }

    }

}
