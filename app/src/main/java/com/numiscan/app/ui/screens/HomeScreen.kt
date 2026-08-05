package com.numiscan.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.ExtractedNumber
import com.numiscan.app.data.model.FilterType
import com.numiscan.app.data.model.NumberType
import com.numiscan.app.ui.components.*

@Composable
fun HomeScreen(

    inputText: TextFieldValue,

    results: List<ExtractedNumber>,

    onTextChange: (TextFieldValue) -> Unit,

    onFilter: (FilterType) -> Unit,

    onExtract: () -> Unit,

    onClear: () -> Unit

) {

    var selectedType by remember {
        mutableStateOf<NumberType?>(null)
    }

    val listState = rememberLazyListState()

    Scaffold(

        topBar = {

            AppTopBar(

                title = "NumiScan"

            )

        }

    ) { padding ->

        LazyColumn(

            state = listState,

            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
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

                if (results.isEmpty()) {

                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        PrimaryButton(

                            text = "تشخیص شماره",

                            onClick = onExtract,

                            modifier = Modifier.align(
                                androidx.compose.ui.Alignment.Center
                            )

                        )

                    }

                } else {

                    Row(

                        modifier = Modifier.fillMaxWidth(),

                        horizontalArrangement = Arrangement.spacedBy(12.dp)

                    ) {

                        Box(
                            modifier = Modifier.weight(1f)
                        ) {

                            PrimaryButton(

                                text = "تشخیص شماره",

                                onClick = onExtract,

                                modifier = Modifier.fillMaxWidth()

                            )

                        }

                        Box(
                            modifier = Modifier.weight(1f)
                        ) {

                            PrimaryButton(

                                text = "حذف نتایج",

                                onClick = onClear,

                                modifier = Modifier.fillMaxWidth(),

                                destructive = true

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

                            it?.let {

                                FilterType.valueOf(it.name)

                            } ?: FilterType.ALL

                        )

                    }

                )

            }

            if (results.isNotEmpty()) {

                item {

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

                    key = {

                        it.type.name + it.value

                    }

                ) { item ->

                    ResultCard(

                        item = item

                    )

                }

            }

        }

    }

}
