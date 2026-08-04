package com.numiscan.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
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

    val search = remember {

        mutableStateOf("")

    }

    Scaffold(

        containerColor =
            MaterialTheme.colorScheme.background,

        topBar = {

            TopAppBar(

                title = {

                    Text("نتایج استخراج")

                },

                navigationIcon = {

                    IconButton(

                        onClick = onBack

                    ) {

                        Icon(

                            Icons.AutoMirrored.Outlined.ArrowBack,

                            null

                        )

                    }

                }

            )

        }

    ) { padding ->

        Column(

            modifier = Modifier

                .padding(padding)

                .fillMaxSize()

        ) {

            SearchBar(

                value = search.value,

                onValueChange = {

                    search.value = it

                    viewModel.search(it)

                }

            )

            ResultToolbar(

                selectedCount =
                    results.count { it.selected },

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

                modifier = Modifier.fillMaxSize(),

                contentPadding = PaddingValues(16.dp),

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
