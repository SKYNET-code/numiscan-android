package com.numiscan.app.ui.components


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun AppDrawer(

    selected: String,

    onNavigate: (String) -> Unit

) {


    ModalDrawerSheet {


        Text(

            text = "NumiScan",

            style = MaterialTheme.typography.headlineSmall,

            modifier = Modifier.padding(

                start = 16.dp,

                top = 24.dp,

                bottom = 16.dp

            )

        )



        NavigationDrawerItem(

            label = {

                Text("خانه")

            },

            selected = selected == "home",

            onClick = {

                onNavigate("home")

            }

        )



        NavigationDrawerItem(

            label = {

                Text("تنظیمات")

            },

            selected = selected == "settings",

            onClick = {

                onNavigate("settings")

            }

        )



        NavigationDrawerItem(

            label = {

                Text("درباره برنامه")

            },

            selected = selected == "about",

            onClick = {

                onNavigate("about")

            }

        )

    }

}
