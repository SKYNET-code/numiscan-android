package com.numiscan.app.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.ExtractedNumber
import com.numiscan.app.data.model.NumberType


@Composable
fun ResultCard(

    item: ExtractedNumber,

    onSelect: () -> Unit,

    onCopy: () -> Unit = {},

    onShare: () -> Unit = {},

    onCall: () -> Unit = {},

    onSms: () -> Unit = {}

){


    Card(

        modifier = Modifier.fillMaxWidth(),

        shape = MaterialTheme.shapes.large

    ){


        Column(

            modifier = Modifier.padding(16.dp),

            verticalArrangement =
                Arrangement.spacedBy(10.dp)

        ){


            Row(

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.SpaceBetween

            ){


                NumberBadge(

                    type = item.type

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
                    MaterialTheme.typography.titleLarge

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
                    item.type == NumberType.MOBILE ||
                    item.type == NumberType.LANDLINE
                ){

                    Button(

                        onClick = onCall

                    ){

                        Text("تماس")

                    }

                }



                if(
                    item.type == NumberType.MOBILE
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
