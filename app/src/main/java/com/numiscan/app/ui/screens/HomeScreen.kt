package com.numiscan.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.numiscan.app.ui.components.*

@Composable
fun HomeScreen(

    state: HomeUiState,

    onTextChange: (String) -> Unit,

    onSearchChange: (String) -> Unit,

    onFilterChange: (com.numiscan.app.data.model.NumberType?) -> Unit,

    onMenuClick: () -> Unit

) {

    Scaffold(

        topBar = {

            HomeTopBar(

                onMenuClick = onMenuClick

            )

        }

    ) { padding ->


        LazyColumn(

            modifier = Modifier

                .fillMaxSize()

                .background(

                    MaterialTheme.colorScheme.background

                )

                .padding(padding),

            contentPadding = PaddingValues(

                horizontal = 16.dp,

                vertical = 16.dp

            ),

            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {


            item {

                InputCard(

                    text = state.inputText,

                    onTextChange = onTextChange

                )

            }


            item {

                SearchBar(

                    query = state.searchQuery,

                    onQueryChange = onSearchChange

                )

            }


            item {

                FilterBar(

                    selectedType = state.selectedType,

                    onTypeSelected = onFilterChange

                )

            }
                        item {

                if (state.results.isNotEmpty()) {

                    ResultSummaryCard(

                        total = state.results.size

                    )

                }

            }


            if (state.results.isEmpty()) {

                item {

                    EmptyState()

                }

            }


            items(

                state.results

            ) { item ->


                ResultCard(

                    item = item

                )


            }


            item {


                StatisticsCard(

                    total = state.results.size,

                    mobile = state.mobileCount,

                    landline = state.landlineCount,

                    bankCard = state.bankCardCount,

                    shaba = state.shabaCount

                )


            }


        }

    }

}
