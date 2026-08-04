package com.numiscan.app.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp



@Composable
fun ResultToolbar(){


    Row(

        modifier =
            Modifier
                .fillMaxWidth()
                .padding(8.dp),

        horizontalArrangement =
            Arrangement.spacedBy(8.dp)

    ){


        Button(

            onClick = {}

        ){

            Text("انتخاب همه")

        }



        Button(

            onClick = {}

        ){

            Text("پاک کردن")

        }

    }

}
