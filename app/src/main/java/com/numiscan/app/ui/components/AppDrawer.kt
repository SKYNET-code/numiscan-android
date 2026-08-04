package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppDrawer(

    onClose: () -> Unit,

    modifier: Modifier = Modifier

) {

    ModalDrawerSheet(

        modifier = modifier
            .fillMaxHeight()

    ) {

        Column(

            modifier = Modifier
                .padding(16.dp)

        ) {

            Text(

                text = "NumiScan",

                style = MaterialTheme.typography.headlineSmall

            )

            Text(

                text = "شماره‌یاب هوشمند",

                style = MaterialTheme.typography.bodyMedium,

                color = MaterialTheme.colorScheme.onSurfaceVariant

            )


            HorizontalDivider(

                modifier = Modifier.padding(vertical = 16.dp)

            )


            NavigationDrawerItem(

                label = {

                    Text("تنظیمات")

                },

                selected = false,

                onClick = {

                },

                icon = {

                    Icon(

                        imageVector = Icons.Outlined.Settings,

                        contentDescription = null

                    )

                }

            )
                        NavigationDrawerItem(

                label = {

                    Text("درباره برنامه")

                },

                selected = false,

                onClick = {

                },

                icon = {

                    Icon(

                        imageVector = Icons.Outlined.Info,

                        contentDescription = null

                    )

                }

            )

        }

    }

}
