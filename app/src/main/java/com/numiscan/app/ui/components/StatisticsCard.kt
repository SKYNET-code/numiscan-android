package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun StatisticsCard(

    count: Int

) {


    Card(

        modifier =
            Modifier.fillMaxWidth(),

        shape =
            MaterialTheme.shapes.large

    ) {


        Row(

            modifier =
                Modifier.padding(16.dp),

        ) {


            Text(

                text = "تعداد شماره‌ها: $count"

            )

        }

    }

}
