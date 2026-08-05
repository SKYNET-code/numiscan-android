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
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.ExtractedNumber
import com.numiscan.app.data.model.FilterType
import com.numiscan.app.data.model.NumberType
import com.numiscan.app.ui.components.*

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

    Scaffold(

        topBar = {

            AppTopBar(

                title = "NumiScan"

            )

        }

    ) { padding ->

        Column(

            modifier = Modifier

                .fillMaxSize()

                .background(MaterialTheme.colorScheme.background)

                .padding(padding)

                .padding(horizontal = 16.dp, vertical = 16.dp)

        ) {

            InputCard(

                text = inputText,

                onTextChange = onTextChange

            )

            Spacer(

                modifier = Modifier.height(16.dp)

            )

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

            Spacer(

                modifier = Modifier.height(16.dp)

            )

            FilterBar(

                selectedType = selectedType,

                onTypeSelected = {

                    selectedType = it

                    onFilter(

                        when (it) {

                            null -> FilterType.ALL

                            else -> FilterType.valueOf(it.name)

                        }

                    )

                }

            )

            if (results.isNotEmpty()) {

                Spacer(

                    modifier = Modifier.height(16.dp)

                )

                ResultSummaryCard(

                    total = results.size

                )

            }

            Spacer(

                modifier = Modifier.height(16.dp)

            )

            Box(

                modifier = Modifier.weight(1f)

            ) {
                                LazyColumn(

                    state = listState,

                    modifier = Modifier.fillMaxSize(),

                    verticalArrangement = Arrangement.spacedBy(16.dp)

                ) {

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

    }

}
