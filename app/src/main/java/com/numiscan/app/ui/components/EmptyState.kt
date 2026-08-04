package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun EmptyState() {


    Card(

        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),

        shape = MaterialTheme.shapes.large

    ) {


        Column(

            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth(),

            horizontalAlignment = Alignment.CenterHorizontally

        ) {


            Text(

                text = "هنوز شماره‌ای استخراج نشده",

                style = MaterialTheme.typography.bodyLarge

            )

        }

    }

}
