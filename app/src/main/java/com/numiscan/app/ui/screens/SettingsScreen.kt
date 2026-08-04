package com.numiscan.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(

    modifier: Modifier = Modifier

) {

    var autoDetect by remember {

        mutableStateOf(true)

    }


    Column(

        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),

        verticalArrangement = Arrangement.spacedBy(20.dp),

        horizontalAlignment = Alignment.Start

    ) {

        Text(

            text = "تنظیمات",

            style = MaterialTheme.typography.headlineSmall

        )


        Text(

            text = "تشخیص خودکار شماره‌ها",

            style = MaterialTheme.typography.titleMedium

        )


        Switch(

            checked = autoDetect,

            onCheckedChange = {

                autoDetect = it

            }

        )

    }

}
