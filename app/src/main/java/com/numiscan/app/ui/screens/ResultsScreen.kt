package com.numiscan.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.numiscan.app.ui.components.FilterBar
import com.numiscan.app.ui.components.ResultCard
import com.numiscan.app.ui.components.ResultToolbar
import com.numiscan.app.ui.components.SearchBar
import com.numiscan.app.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultsScreen(

    onBack: () -> Unit,

    viewModel: MainViewModel = viewModel()

) {

    val results by viewModel.results.collectAsState()

    var search by remember {

        mutableStateOf("")

    }

    Scaffold(

        topBar = {

            CenterAlignedTopAppBar(

                title = {

                    Text("نتایج استخراج")

                },

                navigationIcon = {

                    IconButton(

                        onClick = onBack

                    ) {

                        Icon(

                            Icons.AutoMirrored.Outlined.ArrowBack,

                            contentDescription = null

                        )

                    }

                }

            )

        }

    ) { padding ->

        Column(

            modifier = Modifier

                .padding(padding)

                .padding(16.dp)

                .fillMaxSize(),

            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {

            SearchBar(

                query = search,

                onQueryChange = {

                    search = it

                    viewModel.search(it)

                }

            )

            FilterBar(

                selected = viewModel.currentFilter,

                onSelected = {

                    viewModel.setFilter(it)

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

                    viewModel.clearSelection()

                }

            )

            LazyColumn(

                verticalArrangement = Arrangement.spacedBy(12.dp)

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

}
