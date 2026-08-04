package com.numiscan.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.numiscan.app.ui.components.HomeTopBar
import com.numiscan.app.ui.components.PrimaryButton
import com.numiscan.app.ui.components.SectionTitle
import com.numiscan.app.viewmodel.MainViewModel

@Composable
fun HomeScreen(

    openDrawer: () -> Unit,

    openSettings: () -> Unit,

    openResults: () -> Unit,

    viewModel: MainViewModel = viewModel()

) {

    val text by viewModel.inputText.collectAsState()

    val snackbar = remember {

        SnackbarHostState()

    }

    Scaffold(

        topBar = {

            HomeTopBar(

                onMenuClick = openDrawer,

                onSettingsClick = openSettings

            )

        },

        snackbarHost = {

            SnackbarHost(snackbar)

        }

    ) { padding ->

        Column(

            modifier = Modifier

                .padding(padding)

                .navigationBarsPadding()

                .fillMaxSize()

                .verticalScroll(

                    rememberScrollState()

                )

                .padding(horizontal = 20.dp),

            verticalArrangement =

                Arrangement.spacedBy(18.dp)

        ) {

            SectionTitle(

                text = "متن ورودی"

            )

            OutlinedTextField(

                modifier = Modifier

                    .fillMaxWidth(),

                value = text,

                onValueChange = {

                    viewModel.updateText(it)

                },

                minLines = 10,

                placeholder = {

                    androidx.compose.material3.Text(

                        "پیامک یا متن موردنظر را اینجا وارد کنید..."

                    )

                }

            )

            PrimaryButton(

                text = "استخراج شماره‌ها"

            ) {

                viewModel.extractNumbers()

                openResults()

            }

        }

    }

}
