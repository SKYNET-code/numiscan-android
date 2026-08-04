package com.numiscan.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.numiscan.app.ui.screens.HomeScreen
import com.numiscan.app.ui.screens.SettingsScreen
import com.numiscan.app.viewmodel.MainViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AppNavigation(

    modifier: Modifier = Modifier

) {

    val navController = rememberNavController()

    val mainViewModel: MainViewModel = viewModel()

    NavHost(

        navController = navController,

        startDestination = "home",

        modifier = modifier

    ) {

        composable("home") {

            HomeScreen(

                viewModel = mainViewModel,

                openSettings = {

                    navController.navigate("settings")

                }

            )

        }

        composable("settings") {

            SettingsScreen(

                onBack = {

                    navController.popBackStack()

                }

            )

        }

    }

}
