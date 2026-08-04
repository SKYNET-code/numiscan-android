package com.numiscan.app.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun ResultCard(

    number: String,

    type: String

) {


    Card(

        modifier = Modifier,

    ) {


        ListItem(

            headlineContent = {

                Text(number)

            },

            supportingContent = {

                Text(type)

            }

        )


    }

}
