package com.numiscan.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.ExtractedNumber
import com.numiscan.app.data.model.NumberType

@Composable
fun ResultSummaryCard(

    results: List<ExtractedNumber>

) {

    val mobile =
        results.count {
            it.type == NumberType.MOBILE
        }

    val landline =
        results.count {
            it.type == NumberType.LANDLINE
        }

    val card =
        results.count {
            it.type == NumberType.BANK_CARD
        }

    val shaba =
        results.count {
            it.type == NumberType.SHABA
        }

    Card(

        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(18.dp),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )

    ) {

        Column(

            modifier = Modifier.padding(18.dp)

        ) {

            Text(

                text = "خلاصه نتایج",

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.Bold

            )

            Spacer(

                modifier = Modifier.height(16.dp)

            )

            Row(

                horizontalArrangement = Arrangement.spacedBy(10.dp),

                modifier = Modifier.fillMaxWidth()

            ) {

                SummaryBox(

                    "موبایل",

                    mobile,

                    Color(0xFF4CAF50),

                    Modifier.weight(1f)

                )

                SummaryBox(

                    "ثابت",

                    landline,

                    Color(0xFF2196F3),

                    Modifier.weight(1f)

                )

            }

            Spacer(

                modifier = Modifier.height(10.dp)

            )

            Row(

                horizontalArrangement = Arrangement.spacedBy(10.dp),

                modifier = Modifier.fillMaxWidth()

            ) {

                SummaryBox(

                    "کارت",

                    card,

                    Color(0xFFFF9800),

                    Modifier.weight(1f)

                )

                SummaryBox(

                    "شبا",

                    shaba,

                    Color(0xFF9C27B0),

                    Modifier.weight(1f)

                )

            }

        }

    }

}

@Composable
private fun SummaryBox(

    title: String,

    count: Int,

    color: Color,

    modifier: Modifier = Modifier

) {

    Column(

        modifier = modifier

            .background(

                color.copy(alpha = .12f),

                RoundedCornerShape(14.dp)

            )

            .padding(vertical = 14.dp),

        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Text(

            text = count.toString(),

            style = MaterialTheme.typography.headlineSmall,

            color = color,

            fontWeight = FontWeight.Bold

        )

        Spacer(

            modifier = Modifier.height(4.dp)

        )

        Text(

            text = title,

            color = Color.DarkGray

        )

    }

}
