package com.numiscan.app.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.numiscan.app.ui.components.*
import com.numiscan.app.viewmodel.MainViewModel



@Composable
fun ResultsScreen(

    viewModel: MainViewModel = viewModel(),

    onBack: () -> Unit

) {


    val results by viewModel.results.collectAsState()


    var search by remember {

        mutableStateOf("")

    }



    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text("نتایج استخراج")

                },

                navigationIcon = {

                    IconButton(

                        onClick = onBack

                    ) {

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

                totalCount = results.size,


                onSelectAll = {

                    viewModel.selectAll()

                },


                onClear = {

                    viewModel.clearResults()

                },


                onCopyAll = {

                    viewModel.copySelected()

                },


                onShareAll = {

                    viewModel.shareSelected()

                }

            )



            LazyColumn(

                modifier = Modifier.fillMaxSize(),

                contentPadding = PaddingValues(

                    bottom = 24.dp

                ),

                verticalArrangement =

                    Arrangement.spacedBy(12.dp)

            ){


                items(results){ item ->


                    ResultCard(

                        item = item,


                        onSelect = {

                            viewModel.toggleSelection(

                                item

                            )

                        },


                        onCopy = {


                        },


                        onShare = {


                        },


                        onCall = {


                        },


                        onSms = {


                        }

                    )


                }

            }

        }

    }

}
