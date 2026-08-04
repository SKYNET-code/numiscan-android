package com.numiscan.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(

    onMenuClick: () -> Unit

) {

    TopAppBar(

        title = {

            Text(

                text = "NumiScan",

                style = MaterialTheme.typography.titleLarge

            )

        },

        navigationIcon = {

            IconButton(

                onClick = onMenuClick

            ) {

                Icon(

                    imageVector = Icons.Outlined.Menu,

                    contentDescription = "Menu"

                )

            }

        },

        colors = TopAppBarDefaults.topAppBarColors(

            containerColor = Color.Transparent

        )

    )

}
