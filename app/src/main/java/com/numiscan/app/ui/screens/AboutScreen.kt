package com.numiscan.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AboutScreen(

    modifier: Modifier = Modifier

) {

    Column(

        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center

    ) {

        Text(

            text = "NumiScan",

            style = MaterialTheme.typography.headlineMedium

        )


        Text(

            text = "شناسایی هوشمند شماره‌ها از متن",

            style = MaterialTheme.typography.bodyLarge,

            color = MaterialTheme.colorScheme.onSurfaceVariant,

            modifier = Modifier.padding(top = 8.dp)

        )


        Text(

            text = "نسخه 1.0",

            style = MaterialTheme.typography.bodyMedium,

            modifier = Modifier.padding(top = 16.dp)

        )

    }

}
