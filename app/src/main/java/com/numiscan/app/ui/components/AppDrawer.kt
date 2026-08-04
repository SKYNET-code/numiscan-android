package com.numiscan.app.ui.components


import androidx.compose.material3.*
import androidx.compose.runtime.Composable



@Composable
fun AppDrawer(

    selected: String,

    onNavigate: (String) -> Unit

){


    ModalDrawerSheet {



        TextButton(

            onClick = {

                onNavigate("home")

            }

        ){

            Text("خانه")

        }



        TextButton(

            onClick = {

                onNavigate("settings")

            }

        ){

            Text("تنظیمات")

        }



        TextButton(

            onClick = {

                onNavigate("about")

            }

        ){

            Text("درباره")

        }


    }


}
