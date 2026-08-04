package com.numiscan.app.ui.components


import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier



@Composable
fun AppDrawer(

    selected: String,

    onNavigate: (String) -> Unit

){


    ModalDrawerSheet {


        Text(

            text = "NumiScan",

            style =
                MaterialTheme.typography
                    .headlineSmall,

            modifier =
                Modifier
                    .padding(
                        start = DrawerDefaults.ItemPadding.calculateStartPadding(
                            androidx.compose.ui.unit.LayoutDirection.Ltr
                        ),
                        top = androidx.compose.ui.unit.dp
                    )

        )



        NavigationDrawerItem(

            label = {

                Text("خانه")

            },


            selected =
                selected == "home",


            onClick = {

                onNavigate("home")

            }

        )



        NavigationDrawerItem(

            label = {

                Text("تنظیمات")

            },


            selected =
                selected == "settings",


            onClick = {

                onNavigate("settings")

            }

        )



        NavigationDrawerItem(

            label = {

                Text("درباره برنامه")

            },


            selected =
                selected == "about",


            onClick = {

                onNavigate("about")

            }

        )

    }

}
