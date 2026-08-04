package com.numiscan.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HomeTopBar(

    onMenuClick: () -> Unit,

    onSettingsClick: () -> Unit

) {

    Surface(
        shadowElevation = 2.dp
    ) {

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 18.dp, vertical = 18.dp),

            verticalAlignment = Alignment.CenterVertically

        ) {

            IconButton(
                onClick = onMenuClick
            ) {

                Icon(
                    imageVector = Icons.Outlined.Menu,
                    contentDescription = null
                )

            }

            Spacer(
                modifier = Modifier.weight(1f)
            )

            Text(

                text = "NumiScan",

                style = MaterialTheme.typography.headlineSmall,

                fontWeight = FontWeight.Bold

            )

            Spacer(
                modifier = Modifier.weight(1f)
            )

            IconButton(
                onClick = onSettingsClick
            ) {

                Icon(
                    imageVector = Icons.Outlined.Settings,
                    contentDescription = null
                )

            }

        }

    }

}
