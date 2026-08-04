package com.numiscan.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.numiscan.app.ui.screens.HomeScreen
import com.numiscan.app.ui.screens.ResultsScreen

@Composable
fun AppNavigation(){

    val navController=

        rememberNavController()

    NavHost(

        navController=navController,

        startDestination=AppDestination.Home.route

    ){

        composable(

            AppDestination.Home.route

        ){

            HomeScreen(

                openDrawer={

                },

                openSettings={

                },

                openResults={

                    navController.navigate(

                        AppDestination.Results.route

                    )

                }

            )

        }

        composable(

            AppDestination.Results.route

        ){

            ResultsScreen(

                onBack={

                    navController.popBackStack()

                }

            )

        }

    }

}
