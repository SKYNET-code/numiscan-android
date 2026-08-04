package com.numiscan.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.numiscan.app.ui.components.AppTopBar
import com.numiscan.app.ui.components.InputCard
import com.numiscan.app.utils.ClipboardManager
import com.numiscan.app.viewmodel.MainViewModel

@Composable
fun HomeScreen(

    openDrawer: () -> Unit,

    openResults: () -> Unit,

    viewModel: MainViewModel = viewModel()

) {

    val input by viewModel.inputText.collectAsState()

    val snackbar = remember {

        SnackbarHostState()

    }

    Scaffold(

        topBar = {

            AppTopBar(

                title = "NumiScan",

                onMenuClick = openDrawer

            )

        },

        snackbarHost = {

            SnackbarHost(snackbar)

        }

    ) { padding ->

        Column(

            modifier = Modifier

                .padding(padding)

                .padding(18.dp)

                .fillMaxSize(),

            verticalArrangement = Arrangement.Top

        ) {

            InputCard(

                text = input,

                onTextChange = {

                    viewModel.updateText(it)

                },

                onPaste = {

                    viewModel.updateText(

                        ClipboardManager.paste(it = null)

                    )

                },

                onClear = {

                    viewModel.clearText()

                },

                onExtract = {

                    viewModel.extractNumbers()

                    openResults()

                }

            )

        }

    }

}
