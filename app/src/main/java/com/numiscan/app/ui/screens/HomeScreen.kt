package com.numiscan.app.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.numiscan.app.data.model.FilterType
import com.numiscan.app.ui.components.*
import com.numiscan.app.utils.*
import com.numiscan.app.viewmodel.MainViewModel
import kotlinx.coroutines.launch



@Composable
fun HomeScreen(

    viewModel: MainViewModel = viewModel()

){


    val context =
        LocalContext.current


    val snackbar =
        remember {
            SnackbarHostState()
        }


    val scope =
        rememberCoroutineScope()



    val results by viewModel.results.collectAsState()


    val input by viewModel.inputText.collectAsState()



    var search by remember {

        mutableStateOf("")

    }



    var filter by remember {

        mutableStateOf(
            FilterType.ALL
        )

    }



    Scaffold(

        snackbarHost = {

            SnackbarHost(
                snackbar
            )

        }

    ){ padding ->



        Column(

            modifier =
                Modifier
                    .padding(padding)
                    .padding(16.dp)
                    .fillMaxSize(),

            verticalArrangement =
                Arrangement.spacedBy(12.dp)

        ){



            InputCard(

                text = input,


                onTextChange = {

                    viewModel.updateText(it)

                },


                onExtract = {


                    viewModel.extractNumbers()


                    HapticManager.success(
                        context
                    )


                    scope.launch {

                        SnackbarManager.show(

                            snackbar,

                            "استخراج انجام شد"

                        )

                    }


                },


                onClear = {

                    viewModel.clearText()

                },


                onPaste = {


                    val paste =
                        ClipboardManager.paste(
                            context
                        )


                    viewModel.updateText(
                        paste
                    )


                    scope.launch {

                        SnackbarManager.show(

                            snackbar,

                            "متن جای‌گذاری شد"

                        )

                    }

                }

            )



            ResultActions(

                onCopy = {


                    ClipboardManager.copy(

                        context,

                        results
                            .filter {
                                it.selected
                            }
                            .joinToString("\n"){
                                it.value
                            }

                    )


                    scope.launch {

                        SnackbarManager.show(

                            snackbar,

                            "کپی شد"

                        )

                    }

                },


                onShare = {


                    ShareManager.share(

                        context,

                        results
                            .filter {
                                it.selected
                            }
                            .joinToString("\n"){
                                it.value
                            }

                    )

                }

            )



            SearchBar(

                query = search,


                onQueryChange = {

                    search = it

                    viewModel.search(it)

                }

            )



            FilterBar(

                selected = filter,


                onSelected = {

                    filter = it

                    viewModel.setFilter(it)

                }

            )



            LazyColumn(

                verticalArrangement =
                    Arrangement.spacedBy(8.dp)

            ){


                items(results){ item ->


                    ResultCard(

                        item = item,


                        onSelect = {

                            viewModel.toggleSelection(
                                item
                            )

                        }

                    )


                }


            }


        }


    }

}
