package com.numiscan.app.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp



@Composable
fun ResultActions(){


    Row(

        modifier =
            Modifier.fillMaxWidth(),

        horizontalArrangement =
            Arrangement.spacedBy(8.dp)

    ){


        Button(

            onClick = {}

        ){

            Text("کپی")

        }



        Button(

            onClick = {}

        ){

            Text("اشتراک")

        }


    }

}
