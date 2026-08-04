package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.ExtractedNumber
import androidx.compose.runtime.Immutable

@Composable
fun ResultCard(

    item: ExtractedNumber,

    modifier: Modifier = Modifier

) {

    Card(

        modifier = modifier
            .fillMaxWidth(),

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(

            containerColor = MaterialTheme.colorScheme.surface

        ),

        elevation = CardDefaults.cardElevation(

            defaultElevation = 2.dp

        )

    ) {

        Column(

            modifier = Modifier
                .padding(16.dp),

            verticalArrangement = Arrangement.spacedBy(12.dp)

        ) {

            Row(

                modifier = Modifier.fillMaxWidth(),

                verticalAlignment = Alignment.CenterVertically,

                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                Row(

                    verticalAlignment = Alignment.CenterVertically,

                    horizontalArrangement = Arrangement.spacedBy(10.dp)

                ) {

                    NumberIcon(

                        type = item.type

                    )


                    NumberBadge(

                        type = item.type

                    )

                }


            }

            Text(

                text = item.value,

                style = MaterialTheme.typography.titleLarge

            )
                        ResultActions(

                value = item.value

            )

        }

    }

}
