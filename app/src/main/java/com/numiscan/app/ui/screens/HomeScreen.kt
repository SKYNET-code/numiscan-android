package com.numiscan.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ContentPaste
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.numiscan.app.ui.components.InputCard
import com.numiscan.app.ui.components.ResultSummaryCard
import com.numiscan.app.utils.ClipboardManager
import com.numiscan.app.viewmodel.MainViewModel

@Composable
fun HomeScreen(

    onShowResults: () -> Unit,

    viewModel: MainViewModel = viewModel()

) {

    val context = LocalContext.current

    val input by viewModel.inputText.collectAsState()

    val results by viewModel.results.collectAsState()

    Column(

        modifier = Modifier

            .fillMaxSize()

            .verticalScroll(

                rememberScrollState()

            )

            .padding(20.dp)

    ) {

        Spacer(

            Modifier.height(8.dp)

        )

        Text(

            text = "NumiScan",

            style = MaterialTheme.typography.headlineMedium

        )

        Spacer(

            Modifier.height(6.dp)

        )

        Text(

            text = "استخراج هوشمند شماره‌ها",

            style = MaterialTheme.typography.bodyMedium,

            color = MaterialTheme.colorScheme.onSurfaceVariant

        )

        Spacer(

            Modifier.height(24.dp)

        )
                ElevatedCard(

            modifier = Modifier.fillMaxWidth(),

            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 4.dp
            )

        ) {

            Column(

                modifier = Modifier.padding(18.dp)

            ) {

                OutlinedTextField(

                    value = input,

                    onValueChange = {

                        viewModel.updateText(it)

                    },

                    modifier = Modifier

                        .fillMaxWidth()

                        .height(180.dp),

                    placeholder = {

                        Text(

                            "پیامک، متن یا هر محتوایی را اینجا قرار دهید..."

                        )

                    }

                )

                Spacer(

                    Modifier.height(16.dp)

                )

                Row(

                    modifier = Modifier.fillMaxWidth(),

                    horizontalArrangement = Arrangement.spacedBy(10.dp)

                ) {

                    FilledTonalButton(

                        modifier = Modifier.weight(1f),

                        onClick = {

                            val text = ClipboardManager.paste(context)

                            viewModel.updateText(text)

                        }

                    ) {

                        Icon(

                            Icons.Outlined.ContentPaste,

                            null

                        )

                        Spacer(

                            Modifier.width(8.dp)

                        )

                        Text("چسباندن")

                    }

                    FilledTonalButton(

                        modifier = Modifier.weight(1f),

                        onClick = {

                            viewModel.clearText()

                        }

                    ) {

                        Icon(

                            Icons.Outlined.Delete,

                            null

                        )

                        Spacer(

                            Modifier.width(8.dp)

                        )

                        Text("پاک کردن")

                    }

                }

                Spacer(

                    Modifier.height(18.dp)

                )

                Button(

                    modifier = Modifier

                        .fillMaxWidth()

                        .height(54.dp),

                    onClick = {

                        viewModel.extractNumbers()

                        onShowResults()

                    }

                ) {

                    Text(

                        "استخراج شماره‌ها"

                    )

                }

            }

        }

        Spacer(

            Modifier.height(22.dp)

        )
                if (results.isNotEmpty()) {

            ResultSummaryCard(

                total = results.size,

                mobile = results.count {

                    it.type.name == "MOBILE"

                },

                landline = results.count {

                    it.type.name == "LANDLINE"

                },

                cards = results.count {

                    it.type.name == "BANK_CARD"

                },

                shaba = results.count {

                    it.type.name == "SHABA"

                },

                onOpenResults = {

                    onShowResults()

                }

            )

        }

        Spacer(

            Modifier.height(24.dp)

        )

    }

}
