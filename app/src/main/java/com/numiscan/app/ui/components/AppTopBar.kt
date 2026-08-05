package com.numiscan.app.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(

    title: String = "NumiScan"

) {

    CenterAlignedTopAppBar(

        title = {

            androidx.compose.material3.Text(

                text = title,

                style = MaterialTheme.typography.titleLarge

            )

        },

        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(

            containerColor = MaterialTheme.colorScheme.background

        )

    )

}
