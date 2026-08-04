package com.numiscan.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.numiscan.app.navigation.AppNavigation
import com.numiscan.app.ui.screens.HomeScreen
import com.numiscan.app.ui.theme.NumiScanTheme
import com.numiscan.app.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        handleShareIntent(intent)

        setContent {

            NumiScanTheme {

                val inputText by viewModel.inputText.collectAsState()
                val results by viewModel.results.collectAsState()

                AppNavigation {

                    HomeScreen(

                        inputText = inputText,

                        results = results,

                        onTextChange = {

                            viewModel.updateText(it)

                        },

                        onFilter = {

                            viewModel.setFilter(it)

                        },

                        onExtract = {

                            viewModel.extractNumbers()

                        },

                        onClear = {

                            viewModel.clearResults()

                        }

                    )

                }

            }

        }

    }

    override fun onNewIntent(intent: Intent) {

        super.onNewIntent(intent)

        handleShareIntent(intent)

    }

    private fun handleShareIntent(intent: Intent) {

        if (
            intent.action == Intent.ACTION_SEND &&
            intent.type == "text/plain"
        ) {

            intent.getStringExtra(Intent.EXTRA_TEXT)?.let { text ->

                viewModel.updateText(text)

            }

        }

    }

}
