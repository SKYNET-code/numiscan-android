package com.numiscan.app.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun ResultSummaryCard(

    count: Int,

    onClick: () -> Unit

){


    Card(

        modifier = Modifier

            .fillMaxWidth()

            .clickable {

                onClick()

            },

        shape = MaterialTheme.shapes.large

    ){


        Column(

            modifier =
                Modifier.padding(20.dp)

        ){


            Text(

                text = "نتایج استخراج شده",

                style =
                    MaterialTheme.typography.titleMedium

            )


            Spacer(

                modifier =
                    Modifier.height(8.dp)

            )


            Text(

                text = "$count مورد پیدا شد",

                style =
                    MaterialTheme.typography.bodyLarge

            )


            Spacer(

                modifier =
                    Modifier.height(8.dp)

            )


            Text(

                text = "برای مشاهده نتایج لمس کنید",

                style =
                    MaterialTheme.typography.bodyMedium

            )


        }


    }


}
