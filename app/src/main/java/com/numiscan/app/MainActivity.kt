package com.numiscan.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import com.numiscan.app.navigation.AppNavigation
import com.numiscan.app.ui.screens.HomeScreen
import com.numiscan.app.ui.theme.NumiScanTheme
import com.numiscan.app.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {


    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


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

                        },


                    )

                }

            }

        }

    }

}
