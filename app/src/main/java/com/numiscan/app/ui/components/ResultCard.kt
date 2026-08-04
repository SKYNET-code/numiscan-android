package com.numiscan.app.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.NumberItem



@Composable
fun ResultCard(

    item: NumberItem,

    onSelect: () -> Unit,

    onCopy: () -> Unit = {},

    onShare: () -> Unit = {},

    onCall: () -> Unit = {},

    onSms: () -> Unit = {}

){



    Card(

        modifier = Modifier

            .fillMaxWidth(),

        shape = MaterialTheme.shapes.large

    ){



        Column(

            modifier =
                Modifier.padding(16.dp),

            verticalArrangement =
                Arrangement.spacedBy(8.dp)

        ){



            Row(

                horizontalArrangement =
                    Arrangement.SpaceBetween

            ){


                Text(

                    text = item.type.name,

                    style =
                        MaterialTheme.typography.labelMedium

                )



                Checkbox(

                    checked = item.selected,

                    onCheckedChange = {

                        onSelect()

                    }

                )


            }





            Text(

                text = item.value,

                style =
                    MaterialTheme.typography.titleMedium

            )





            Row(

                horizontalArrangement =
                    Arrangement.spacedBy(8.dp)

            ){



                Button(

                    onClick = onCopy

                ){

                    Text("کپی")

                }



                Button(

                    onClick = onShare

                ){

                    Text("اشتراک")

                }



                if(
                    item.type.name == "MOBILE"
                    ||
                    item.type.name == "LANDLINE"
                ){


                    Button(

                        onClick = onCall

                    ){

                        Text("تماس")

                    }


                }



                if(
                    item.type.name == "MOBILE"
                ){


                    Button(

                        onClick = onSms

                    ){

                        Text("SMS")

                    }


                }


            }


        }


    }


}
