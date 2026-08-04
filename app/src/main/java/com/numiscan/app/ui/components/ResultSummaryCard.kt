package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.SimCard
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ResultSummaryCard(

    total: Int,

    mobile: Int,

    landline: Int,

    cards: Int,

    shaba: Int,

    onOpenResults: () -> Unit

) {

    ElevatedCard(

        modifier = Modifier.fillMaxWidth(),

        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 4.dp
        )

    ) {

        Column(

            modifier = Modifier.padding(18.dp)

        ) {

            Text(

                text = "خلاصه نتایج",

                style = MaterialTheme.typography.titleLarge,

                fontWeight = FontWeight.Bold

            )

            Spacer(Modifier.height(18.dp))

            SummaryRow(
                Icons.Outlined.Phone,
                "شماره موبایل",
                mobile
            )

            SummaryRow(
                Icons.Outlined.SimCard,
                "تلفن ثابت",
                landline
            )

            SummaryRow(
                Icons.Outlined.CreditCard,
                "کارت بانکی",
                cards
            )

            SummaryRow(
                Icons.Outlined.AccountBalance,
                "شماره شبا",
                shaba
            )

            HorizontalDivider()

            Spacer(Modifier.height(12.dp))

            Text(

                text = "جمع کل: $total",

                style = MaterialTheme.typography.titleMedium

            )

            Spacer(Modifier.height(16.dp))

            Button(

                modifier = Modifier.fillMaxWidth(),

                onClick = onOpenResults

            ) {

                Text(

                    "مشاهده نتایج"

                )

                Spacer(Modifier.width(8.dp))

                Icon(

                    Icons.Outlined.ChevronRight,

                    null

                )

            }

        }

    }

}

@Composable
private fun SummaryRow(

    icon: androidx.compose.ui.graphics.vector.ImageVector,

    title: String,

    count: Int

) {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),

        verticalAlignment = Alignment.CenterVertically

    ) {

        Icon(

            icon,

            null

        )

        Spacer(Modifier.width(10.dp))

        Text(

            text = title,

            modifier = Modifier.weight(1f)

        )

        Text(

            text = count.toString(),

            style = MaterialTheme.typography.titleMedium,

            fontWeight = FontWeight.Bold

        )

    }

}
