package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun InputCard(

    text: String,

    onTextChange: (String) -> Unit

) {


    Card(

        modifier = Modifier.fillMaxWidth(),

        shape = MaterialTheme.shapes.large

    ) {


        Column(

            modifier = Modifier.padding(16.dp),

            verticalArrangement = Arrangement.spacedBy(12.dp)

        ) {


            OutlinedTextField(

                value = text,

                onValueChange = onTextChange,

                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 150.dp),

                label = {

                    Text("متن ورودی")

                },

                placeholder = {

                    Text("متن را اینجا قرار دهید")

                }

            )


            Button(

                onClick = {},

                modifier = Modifier.fillMaxWidth()

            ) {

                Text("استخراج شماره‌ها")

            }

        }

    }

}
