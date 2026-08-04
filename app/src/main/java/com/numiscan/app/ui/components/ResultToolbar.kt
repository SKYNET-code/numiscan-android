package com.numiscan.app.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier



@Composable
fun ResultToolbar(

    onSelectAll: () -> Unit,

    onClear: () -> Unit

){


    Row(

        modifier =
            Modifier.fillMaxWidth(),

        horizontalArrangement =
            Arrangement.spacedBy(8.dp)

    ){


        OutlinedButton(

            onClick = onSelectAll,

            modifier =
                Modifier.weight(1f)

        ){

            Text("انتخاب همه")

        }



        OutlinedButton(

            onClick = onClear,

            modifier =
                Modifier.weight(1f)

        ){

            Text("پاک کردن")

        }

    }

}
