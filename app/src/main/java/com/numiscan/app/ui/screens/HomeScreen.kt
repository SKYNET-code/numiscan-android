package com.numiscan.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.ExtractedNumber
import com.numiscan.app.data.model.FilterType
import com.numiscan.app.ui.components.*
import com.numiscan.app.data.model.NumberType
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults


@Composable
fun HomeScreen(

    inputText: String,

    results: List<ExtractedNumber>,

    onTextChange: (String) -> Unit,

    onFilter: (FilterType) -> Unit,

    onExtract: () -> Unit,

    onClear: () -> Unit

) {

    var selectedType by remember {
        mutableStateOf<NumberType?>(null)
    }


    val listState = rememberLazyListState()
    val flingBehavior = ScrollableDefaults.flingBehavior()

    Scaffold(

    ) { padding ->


        LazyColumn(

            state = listState,

            modifier = Modifier

                .fillMaxSize()

                .background(

                    MaterialTheme.colorScheme.background

                )

                .padding(padding),
            
            flingBehavior = flingBehavior,

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

                Row(

                    modifier = Modifier.fillMaxWidth(),

                    horizontalArrangement = Arrangement.spacedBy(8.dp)

                ) {


                    Box(

                        modifier = Modifier.weight(1f)

                    ) {

                        PrimaryButton(

                            text = "شناسایی شماره‌ها",

                            onClick = onExtract

                        )

                    }


                    if (results.isNotEmpty()) {

                        Box(

                            modifier = Modifier.weight(1f)

                        ) {

                            PrimaryButton(

                                text = "حذف نتایج",

                                onClick = onClear

                            )

                        }

                    }

                }

            }


            item {

                FilterBar(

                    selectedType = selectedType,

                    onTypeSelected = {

                        selectedType = it

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

                        items = results,
                        key = { it.type.name + it.value }

                ) { item ->


                    ResultCard(

                        item = item

                    )


                }


            }

        }

    }

}
