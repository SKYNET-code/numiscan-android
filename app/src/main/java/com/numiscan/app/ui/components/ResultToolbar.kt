package com.numiscan.app.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier



@Composable
fun ResultToolbar(

    selectedCount: Int,

    totalCount: Int,

    onSelectAll: () -> Unit,

    onClear: () -> Unit

){



    Row(

        modifier =
            Modifier.fillMaxWidth(),

        horizontalArrangement =
            Arrangement.SpaceBetween

    ){



        Button(

            onClick = onSelectAll

        ){

            Text(
                "انتخاب همه ($totalCount)"
            )

        }



        Button(

            onClick = onClear

        ){

            Text(
                "پاک کردن"
            )

        }


    }


}
