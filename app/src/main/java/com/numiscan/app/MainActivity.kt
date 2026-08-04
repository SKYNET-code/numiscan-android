package com.numiscan.app


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.numiscan.app.ui.screens.HomeScreen
import com.numiscan.app.ui.screens.ResultsScreen
import com.numiscan.app.ui.theme.NumiScanTheme



class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        setContent {


            NumiScanTheme {


                var currentScreen by remember {

                    mutableStateOf("home")

                }



                when(currentScreen){


                    "home" -> {


                        HomeScreen(

                            onOpenResults = {

                                currentScreen = "results"

                            }

                        )


                    }



                    "results" -> {


                        ResultsScreen(

                            onBack = {

                                currentScreen = "home"

                            }

                        )


                    }


                }


            }


        }


    }


}
