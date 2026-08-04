package com.numiscan.app.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.ExtractedNumber


@Composable
fun ResultCard(

    item: ExtractedNumber,

    onSelect: () -> Unit

) {


    Card(

        modifier = Modifier
            .fillMaxWidth()
            .clickable {

                onSelect()

            },


        shape = MaterialTheme.shapes.large

    ) {


        Row(

            modifier =
                Modifier.padding(16.dp),

            horizontalArrangement =
                Arrangement.SpaceBetween

        ) {


            Column {


                Text(

                    text = item.value,

                    style =
                        MaterialTheme
                            .typography
                            .titleMedium

                )


                Text(

                    text = item.type.name

                )

            }



            Checkbox(

                checked = item.selected,

                onCheckedChange = {

                    onSelect()

                }

            )

        }

    }

}
