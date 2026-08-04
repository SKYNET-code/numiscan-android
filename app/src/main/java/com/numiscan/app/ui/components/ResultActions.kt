package com.numiscan.app.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier



@Composable
fun ResultActions(

    onCopy: () -> Unit,

    onShare: () -> Unit

){


    Row(

        modifier =
            Modifier.fillMaxWidth(),

        horizontalArrangement =
            Arrangement.spacedBy(8.dp)

    ){


        Button(

            onClick = onCopy,

            modifier =
                Modifier.weight(1f)

        ){

            Text("کپی")

        }



        OutlinedButton(

            onClick = onShare,

            modifier =
                Modifier.weight(1f)

        ){

            Text("اشتراک")

        }

    }

}
