package com.numiscan.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.numiscan.app.ui.components.InputCard
import com.numiscan.app.ui.components.EmptyState


@Composable
fun HomeScreen() {

    var text by remember {
        mutableStateOf("")
    }


    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {


        Text(

            text = "NumiScan",

            style = MaterialTheme.typography.headlineMedium

        )


        InputCard(

            text = text,

            onTextChange = {

                text = it

            }

        )


        EmptyState()

    }

}
