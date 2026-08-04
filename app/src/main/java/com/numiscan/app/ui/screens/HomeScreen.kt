package com.numiscan.app.ui.screens


import android.content.Context
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
import com.numiscan.app.utils.ClipboardManager
import com.numiscan.app.utils.ShareManager
import com.numiscan.app.viewmodel.MainViewModel



@Composable
fun HomeScreen(

    viewModel: MainViewModel = viewModel()

){


    val context =
        LocalContext.current


    val results by viewModel.results.collectAsState()


    val input by viewModel.inputText.collectAsState()



    var search by remember {

        mutableStateOf("")

    }



    var filter by remember {

        mutableStateOf(FilterType.ALL)

    }



    val selectedText =
        results
            .filter {
                it.selected
            }
            .joinToString("\n"){
                it.value
            }



    Column(

        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),

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

            },


            onClear = {

                viewModel.clearText()

            }

        )



        ResultActions(

            onCopy = {

                ClipboardManager.copy(
                    context,
                    selectedText
                )

            },


            onShare = {

                ShareManager.share(
                    context,
                    selectedText
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

                        viewModel.toggleSelection(item)

                    }

                )

            }

        }

    }

}
