package com.numiscan.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.numiscan.app.ui.components.InputCard
import com.numiscan.app.ui.components.FilterBar
import com.numiscan.app.ui.components.ResultCard
import com.numiscan.app.ui.components.ResultSummaryCard
import com.numiscan.app.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(

    viewModel: MainViewModel,

    openSettings: () -> Unit

) {

    val text by viewModel.inputText.collectAsState()

    val results by viewModel.results.collectAsState()

    Scaffold(

        containerColor = Color(0xFFF5F6F8),

        topBar = {

            TopAppBar(

                title = {

                    Text(

                        text = "NumiScan",

                        fontSize = 20.sp,

                        color = MaterialTheme.colorScheme.primary

                    )

                },

                navigationIcon = {

                    IconButton(

                        onClick = openSettings

                    ) {

                        Icon(

                            Icons.Default.Menu,

                            contentDescription = null

                        )

                    }

                },

                colors = TopAppBarDefaults.topAppBarColors(

                    containerColor = Color.White

                )

            )

        }

    ) { padding ->

        Column(

            modifier = Modifier

                .fillMaxSize()

                .padding(padding)
                .padding(16.dp)

        ) {
                        InputCard(

                text = text,

                onTextChange = {

                    viewModel.updateText(it)

                }

            )

            Spacer(

                modifier = Modifier.height(16.dp)

            )

            Button(

                onClick = {

                    viewModel.extractNumbers()

                },

                modifier = Modifier.fillMaxWidth()

            ) {

                Text("استخراج شماره‌ها")

            }

            Spacer(

                modifier = Modifier.height(16.dp)

            )

            if (results.isNotEmpty()) {

                ResultSummaryCard(

                    results = results

                )

                Spacer(

                    modifier = Modifier.height(16.dp)

                )

                FilterBar(

                    selected = FilterType.ALL,

                    onSelected = {

                        viewModel.setFilter(it)

                    }

                )

                Spacer(

                    modifier = Modifier.height(16.dp)

                )

                Text(

                    text = "نتایج استخراج",

                    style = MaterialTheme.typography.titleMedium

                )

                Spacer(

                    modifier = Modifier.height(8.dp)

                )
                                Box(

                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)

                ) {

                    LazyColumn(

                        modifier = Modifier.fillMaxSize(),

                        verticalArrangement = Arrangement.spacedBy(12.dp),

                        contentPadding = PaddingValues(bottom = 16.dp)

                    ) {

                        items(

                            items = results,

                            key = { it.value }

                        ) { item ->

                            ResultCard(

                                item = item,

                                onSelect = {

                                    viewModel.toggleSelection(item)

                                }

                            )

                        }

                    }

                }

            } else {

                Box(

                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),

                    contentAlignment = Alignment.Center

                ) {

                    Text(

                        text = "هنوز شماره‌ای استخراج نشده است.",

                        color = Color.Gray,

                        style = MaterialTheme.typography.bodyMedium

                    )

                }

            }
                    }

    }

}
