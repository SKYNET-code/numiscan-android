package com.numiscan.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.numiscan.app.ui.screens.AboutScreen
import com.numiscan.app.ui.screens.HomeScreen
import com.numiscan.app.ui.screens.SettingsScreen

sealed class Screen(val route: String) {

    data object Home : Screen("home")

    data object Settings : Screen("settings")

    data object About : Screen("about")

}


@Composable
fun AppNavigation(

    homeScreen: @Composable () -> Unit

) {

    val navController = rememberNavController()


    NavHost(

        navController = navController,

        startDestination = Screen.Home.route

    ) {


        composable(

            Screen.Home.route

        ) {

            homeScreen()

        }


        composable(

            Screen.Settings.route

        ) {

            SettingsScreen()

        }


        composable(

            Screen.About.route

        ) {

            AboutScreen()

        }

    }

}
