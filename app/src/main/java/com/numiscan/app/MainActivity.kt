package com.numiscan.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.numiscan.app.navigation.AppNavigation
import com.numiscan.app.ui.screens.HomeScreen
import com.numiscan.app.ui.theme.NumiScanTheme
import com.numiscan.app.viewmodel.MainViewModel
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState


class MainActivity : ComponentActivity() {


    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        setContent {


            NumiScanTheme {


                val state by viewModel.uiState.collectAsState()


                AppNavigation {


                    HomeScreen(

                        state = state,

                        onTextChange = viewModel::updateText,

                        onSearchChange = viewModel::updateSearch,

                        onFilterChange = viewModel::setFilter,

                        onMenuClick = {}

                    )

                }


            }

        }

    }

}
