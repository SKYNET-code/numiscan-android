package com.numiscan.app.ui.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(

    title: String,

    onMenuClick: () -> Unit

){


    TopAppBar(

        title = {

            Text(title)

        },


        navigationIcon = {


            IconButton(

                onClick = onMenuClick

            ){


                Icon(

                    imageVector =
                        Icons.Default.Menu,

                    contentDescription = null

                )

            }

        }

    )

}
