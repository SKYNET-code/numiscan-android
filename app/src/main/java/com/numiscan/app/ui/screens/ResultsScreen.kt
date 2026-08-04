package com.numiscan.app.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.numiscan.app.ui.components.ResultCard
import com.numiscan.app.ui.components.ResultToolbar
import com.numiscan.app.ui.components.SearchBar
import com.numiscan.app.viewmodel.MainViewModel



@Composable
fun ResultsScreen(

    onBack: () -> Unit,

    viewModel: MainViewModel = viewModel()

){


    val results by viewModel.results.collectAsState()


    var search by remember {

        mutableStateOf("")

    }



    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text(
                        "نتایج"
                    )

                },


                navigationIcon = {

                    IconButton(

                        onClick = onBack

                    ){

                        Text("‹")

                    }

                }

            )

        }

    ){ padding ->



        Column(

            modifier = Modifier

                .padding(padding)

                .padding(16.dp)

                .fillMaxSize(),

            verticalArrangement =

                Arrangement.spacedBy(12.dp)

        ){



            SearchBar(

                query = search,

                onQueryChange = {

                    search = it

                    viewModel.search(it)

                }

            )



            ResultToolbar(

                selectedCount =
                    results.count {

                        it.selected

                    },


                totalCount =
                    results.size,


                onSelectAll = {

                    viewModel.selectAll()

                },


                onClear = {

                    viewModel.clearResults()

                }

            )



            LazyColumn(

                verticalArrangement =

                    Arrangement.spacedBy(12.dp)

            ){



                items(results){ item ->



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


}
