package com.numiscan.app.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun SettingsScreen(

    darkMode: Boolean,

    onDarkModeChange: (Boolean) -> Unit

){


    Column(

        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),

        verticalArrangement =
            Arrangement.spacedBy(16.dp)

    ){



        Text(

            text = "تنظیمات",

            style =
                MaterialTheme.typography
                    .headlineMedium

        )



        Row(

            modifier =
                Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.SpaceBetween

        ){


            Text("حالت تاریک")


            Switch(

                checked = darkMode,

                onCheckedChange =
                    onDarkModeChange

            )

        }

    }

}
