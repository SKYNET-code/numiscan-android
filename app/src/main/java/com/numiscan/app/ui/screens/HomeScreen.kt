package com.numiscan.app.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.numiscan.app.ui.components.InputCard
import com.numiscan.app.ui.components.ResultSummaryCard
import com.numiscan.app.utils.ClipboardManager
import com.numiscan.app.utils.HapticManager
import com.numiscan.app.utils.SnackbarManager
import com.numiscan.app.viewmodel.MainViewModel
import kotlinx.coroutines.launch



@Composable
fun HomeScreen(

    onOpenResults: () -> Unit,

    viewModel: MainViewModel = viewModel()

){


    val context = LocalContext.current


    val input by viewModel.inputText.collectAsState()


    val results by viewModel.results.collectAsState()


    val snackbarHostState =
        remember {
            SnackbarHostState()
        }


    val scope =
        rememberCoroutineScope()



    Scaffold(

        snackbarHost = {

            SnackbarHost(
                snackbarHostState
            )

        }

    ){ padding ->



        Column(

            modifier = Modifier

                .padding(padding)

                .padding(16.dp)

                .fillMaxSize(),

            verticalArrangement =

                Arrangement.spacedBy(16.dp)

        ){



            InputCard(

                text = input,

                onTextChange = {

                    viewModel.updateText(it)

                },


                onExtract = {


                    viewModel.extractNumbers()


                    HapticManager.success(context)



                    scope.launch {

                        SnackbarManager.show(

                            snackbarHostState,

                            "استخراج انجام شد"

                        )

                    }


                },


                onClear = {

                    viewModel.clearText()

                },


                onPaste = {


                    val text =
                        ClipboardManager.paste(context)


                    viewModel.updateText(text)


                }

            )



            ResultSummaryCard(

                count = results.size,


                onClick = {

                    onOpenResults()

                }

            )


        }


    }


}
