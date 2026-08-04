package com.numiscan.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.numiscan.app.ui.components.ResultCard
import com.numiscan.app.ui.components.ResultToolbar
import com.numiscan.app.ui.components.SearchBar
import com.numiscan.app.utils.ClipboardManager
import com.numiscan.app.utils.ShareManager
import com.numiscan.app.viewmodel.MainViewModel
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultsScreen(

    onBack: () -> Unit,

    viewModel: MainViewModel = viewModel()

) {

    val context = LocalContext.current

    val results by viewModel.results.collectAsState()

    var search by remember {

        mutableStateOf("")

    }

    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text("نتایج")

                },

                navigationIcon = {

                    TextButton(

                        onClick = onBack

                    ) {

                        Text("بازگشت")

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

            ResultToolbar(

                selectedCount = results.count { it.selected },

                totalCount = results.size,

                onSelectAll = {

                    viewModel.selectAll()

                },

                onClear = {

                    viewModel.clearResults()

                }

            )

            LazyColumn(

                verticalArrangement = Arrangement.spacedBy(14.dp)

            ) {

                items(results) { item ->

                    ResultCard(

                        item = item,

                        onSelect = {

                            viewModel.toggleSelection(item)

                        },

                        onCopy = {

                            ClipboardManager.copy(

                                context,

                                item.value

                            )

                        },

                        onCall = {

                            // مرحله بعد

                        },

                        onShare = {

                            ShareManager.share(

                                context,

                                item.value

                            )

                        }

                    )

                }

            }

        }

    }

}
