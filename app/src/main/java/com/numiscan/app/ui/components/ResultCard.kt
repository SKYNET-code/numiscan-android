package com.numiscan.app.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.ExtractedNumber



@Composable
fun ResultCard(

    item: ExtractedNumber,

    onSelect: () -> Unit

){


    Card(

        modifier =
            Modifier
                .fillMaxWidth()
                .clickable {

                    onSelect()

                },


        shape =
            MaterialTheme.shapes.large


    ){



        Row(

            modifier =
                Modifier.padding(16.dp),


            verticalAlignment =
                Alignment.CenterVertically

        ){



            NumberIcon(

                type = item.type

            )



            Spacer(

                modifier =
                    Modifier.width(12.dp)

            )



            Column(

                modifier =
                    Modifier.weight(1f)

            ){



                Text(

                    text = item.value,

                    style =
                        MaterialTheme
                            .typography
                            .titleMedium

                )



                NumberBadge(

                    type = item.type

                )


            }



            Checkbox(

                checked =
                    item.selected,


                onCheckedChange = {

                    onSelect()

                }

            )

        }

    }

}
