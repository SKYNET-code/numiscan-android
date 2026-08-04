package com.numiscan.app


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.material3.ModalNavigationDrawer
import com.numiscan.app.ui.components.AppDrawer
import com.numiscan.app.ui.components.AppTopBar
import com.numiscan.app.ui.screens.*
import com.numiscan.app.ui.theme.NumiScanTheme



class MainActivity : ComponentActivity(){


    override fun onCreate(
        savedInstanceState: Bundle?
    ){

        super.onCreate(savedInstanceState)


        setContent {


            var darkMode by rememberSaveable {

                mutableStateOf(false)

            }



            NumiScanTheme(

                darkTheme = darkMode

            ){


                var page by remember {

                    mutableStateOf("home")

                }



                val drawerState =
                    rememberDrawerState(
                        DrawerValue.Closed
                    )



                val scope =
                    rememberCoroutineScope()



                ModalNavigationDrawer(


                    drawerContent = {


                        AppDrawer(

                            selected = page,


                            onNavigate = {

                                page = it

                            }

                        )

                    }


                ){


                    Scaffold(

                        topBar = {


                            AppTopBar(

                                title =
                                    "NumiScan",

                                onMenuClick = {

                                }

                            )

                        }

                    ){ padding ->



                        when(page){


                            "home" ->
                                HomeScreen()



                            "settings" ->
                                SettingsScreen(

                                    darkMode,

                                    {
                                        darkMode = it
                                    }

                                )



                            "about" ->
                                AboutScreen()

                        }

                    }

                }

            }

        }

    }

}
