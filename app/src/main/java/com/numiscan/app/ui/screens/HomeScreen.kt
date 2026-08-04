package com.numiscan.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.ExtractedNumber
import com.numiscan.app.data.model.FilterType
import com.numiscan.app.ui.components.*

@Composable
fun HomeScreen(

    inputText: String,

    results: List<ExtractedNumber>,

    onTextChange: (String) -> Unit,

    onSearch: (String) -> Unit,

    onFilter: (FilterType) -> Unit,

    onExtract: () -> Unit,

    onClear: () -> Unit,

    

) {


    Scaffold(

        topBar = {

            AppTopBar(
                    title = "NumiScan",
        
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

                    text = inputText,

                    onTextChange = onTextChange

                )

            }


            item {

                PrimaryButton(

                    text = "شناسایی شماره‌ها",

                    onClick = onExtract

                )

            }
                        item {

                SearchBar(

                    query = "",

                    onQueryChange = onSearch

                )

            }


            item {

                FilterBar(

                    selectedType = null,

                    onTypeSelected = {

                        onFilter(

                            when (it) {

                                null ->
                                    FilterType.ALL

                                else ->
                                    FilterType.valueOf(

                                        it.name

                                    )

                            }

                        )

                    }

                )

            }


            item {

                if (results.isNotEmpty()) {

                    ResultSummaryCard(

                        total = results.size

                    )

                }

            }


            if (results.isEmpty()) {


                item {

                    EmptyState()

                }


            } else {


                items(

                    results

                ) { item ->


                    ResultCard(

                        item = item

                    )


                }


            }


            item {

                if (results.isNotEmpty()) {

                    ResultToolbar(

                        onClear = onClear,

                        

                    )

                }

            }


        }

    }

}
