package com.numiscan.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.numiscan.app.ui.screens.HomeScreen
import com.numiscan.app.ui.screens.ResultsScreen

object Routes {

    const val HOME = "home"

    const val RESULTS = "results"

}

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(

        navController = navController,

        startDestination = Routes.HOME

    ) {

        composable(Routes.HOME) {

            HomeScreen(

                onShowResults = {

                    navController.navigate(

                        Routes.RESULTS

                    )

                }

            )

        }

        composable(Routes.RESULTS) {

            ResultsScreen(

                onBack = {

                    navController.popBackStack()

                }

            )

        }

    }

}
