package com.numiscan.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.numiscan.app.ui.components.InputCard
import com.numiscan.app.ui.components.ResultCard
import com.numiscan.app.ui.components.StatisticsCard
import com.numiscan.app.viewmodel.MainViewModel


@Composable
fun HomeScreen(

    viewModel: MainViewModel = viewModel()

) {


    val results by viewModel.results.collectAsState()


    val input by viewModel.inputText.collectAsState()



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

            text = input,

            onTextChange = {

                viewModel.updateText(it)

            },

            onExtract = {

                viewModel.extractNumbers()

            },

            onClear = {

                viewModel.clearText()

            }

        )



        StatisticsCard(

            count = results.size

        )



        LazyColumn(

            verticalArrangement = Arrangement.spacedBy(8.dp)

        ) {


            items(results) { item ->


                ResultCard(

                    item = item,

                    onSelect = {

                        viewModel.toggleSelection(item)

                    }

                )

            }

        }

    }

}
