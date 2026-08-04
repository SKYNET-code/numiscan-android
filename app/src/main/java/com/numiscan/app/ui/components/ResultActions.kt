package com.numiscan.app.ui.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun ResultActions(

    onCopy: () -> Unit,

    onShare: () -> Unit

) {


    Row(

        modifier = Modifier.fillMaxWidth(),

        horizontalArrangement =
            Arrangement.spacedBy(8.dp)

    ) {


        Button(

            onClick = onCopy

        ) {

            Text("کپی")

        }



        Button(

            onClick = onShare

        ) {

            Text("اشتراک")

        }

    }

}
