package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp

@Composable
fun ResultSummaryCard(

    total: Int

) {

    Card(

        modifier = Modifier.fillMaxWidth(),

        colors = CardDefaults.cardColors(

            containerColor = MaterialTheme.colorScheme.surface

        )

    ) {

        Column(

            modifier = Modifier.padding(16.dp),

            verticalArrangement = Arrangement.spacedBy(6.dp)

        ) {

            Text(

                text = "تعداد نتایج پیدا شده",

                modifier = Modifier.fillMaxWidth(),

                textAlign = TextAlign.End,

                style = MaterialTheme.typography.titleMedium

            )

            Text(

                text = total.toString(),

                modifier = Modifier.fillMaxWidth(),

                textAlign = TextAlign.End,

                style = MaterialTheme.typography.headlineSmall.copy(

                    textDirection = TextDirection.ContentOrRtl

                ),

                color = MaterialTheme.colorScheme.primary

            )

        }

    }

}
