package com.numiscan.app.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun AboutScreen(){


    Column(

        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp)

    ){


        Text(

            text = "NumiScan",

            style =
                MaterialTheme.typography
                    .headlineMedium

        )


        Spacer(

            modifier =
                Modifier.height(8.dp)

        )


        Text(

            text =
                "Smart number extractor"

        )

    }

}
