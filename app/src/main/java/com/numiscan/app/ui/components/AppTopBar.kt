package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.numiscan.app.ui.theme.Background

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(

    title: String,

    onMenuClick: () -> Unit

) {

    CenterAlignedTopAppBar(

        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(

            containerColor = Background

        ),

        navigationIcon = {

            IconButton(

                onClick = onMenuClick

            ) {

                Icon(

                    imageVector = Icons.Rounded.Menu,

                    contentDescription = null

                )

            }

        },

        title = {

            Row {

                Text(

                    text = title,

                    style = MaterialTheme.typography.titleLarge

                )

            }

        }

    )

}
