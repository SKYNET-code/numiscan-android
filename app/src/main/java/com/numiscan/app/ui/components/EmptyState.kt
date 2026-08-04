package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.SearchOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EmptyState(

    modifier: Modifier = Modifier

) {

    Column(

        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 48.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.spacedBy(12.dp)

    ) {

        Icon(

            imageVector = Icons.Outlined.SearchOff,

            contentDescription = null,

            tint = MaterialTheme.colorScheme.primary,

            modifier = Modifier

        )


        Text(

            text = "نتیجه‌ای پیدا نشد",

            style = MaterialTheme.typography.titleMedium

        )


        Text(

            text = "متن را وارد کنید تا شماره‌ها شناسایی شوند",

            style = MaterialTheme.typography.bodyMedium,

            color = MaterialTheme.colorScheme.onSurfaceVariant

        )

    }

}
