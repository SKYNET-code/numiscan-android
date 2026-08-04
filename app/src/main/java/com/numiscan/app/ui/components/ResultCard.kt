package com.numiscan.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.ExtractedNumber
import com.numiscan.app.data.model.NumberType

@Composable
fun ResultCard(

    item: ExtractedNumber,

    onSelect: () -> Unit,

    onCopy: (() -> Unit)? = null,

    onShare: (() -> Unit)? = null,

    onCall: (() -> Unit)? = null

) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelect() },

        shape = RoundedCornerShape(18.dp),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),

        colors = CardDefaults.cardColors(

            containerColor =
                if (item.selected)
                    MaterialTheme.colorScheme.primaryContainer
                else
                    MaterialTheme.colorScheme.surface

        )

    ) {

        Column(

            modifier = Modifier.padding(18.dp)

        ) {

            Row(

                verticalAlignment = Alignment.CenterVertically

            ) {

                NumberBadge(item.type)

                Spacer(
                    Modifier.weight(1f)
                )

                if (item.selected) {

                    Icon(

                        Icons.Outlined.CheckCircle,

                        contentDescription = null

                    )

                }

            }

            Spacer(
                Modifier.height(14.dp)
            )

            Text(

                text = item.value,

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.Bold

            )

            Spacer(
                Modifier.height(12.dp)
            )

            Text(

                text = when (item.type) {

                    NumberType.MOBILE ->
                        "شماره موبایل"

                    NumberType.LANDLINE ->
                        "تلفن ثابت"

                    NumberType.BANK_CARD ->
                        "شماره کارت"

                    NumberType.SHABA ->
                        "شماره شبا"

                },

                style = MaterialTheme.typography.bodyMedium

            )

            Spacer(
                Modifier.height(16.dp)
            )

            HorizontalDivider()

            Spacer(
                Modifier.height(8.dp)
            )

            Row(

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceEvenly

            ) {

                TextButton(

                    onClick = {

                        onCopy?.invoke()

                    }

                ) {

                    Icon(

                        Icons.Outlined.ContentCopy,

                        contentDescription = null

                    )

                    Spacer(
                        Modifier.width(4.dp)
                    )

                    Text("کپی")

                }

                TextButton(

                    onClick = {

                        onShare?.invoke()

                    }

                ) {

                    Icon(

                        Icons.Outlined.Share,

                        contentDescription = null

                    )

                    Spacer(
                        Modifier.width(4.dp)
                    )

                    Text("اشتراک")

                }

                if (

                    item.type == NumberType.MOBILE ||

                    item.type == NumberType.LANDLINE

                ) {

                    TextButton(

                        onClick = {

                            onCall?.invoke()

                        }

                    ) {

                        Icon(

                            Icons.Outlined.Call,

                            contentDescription = null

                        )

                        Spacer(
                            Modifier.width(4.dp)
                        )

                        Text("تماس")

                    }

                }

            }

        }

    }

}
