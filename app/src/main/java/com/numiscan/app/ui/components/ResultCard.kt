package com.numiscan.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.ContentCopy
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.ExtractedNumber
import com.numiscan.app.ui.theme.CardBorder
import com.numiscan.app.ui.theme.DividerColor
import com.numiscan.app.ui.theme.Surface as CardSurface

@Composable
fun ResultCard(

    item: ExtractedNumber,

    onSelect: () -> Unit,

    onCopy: () -> Unit = {},

    onCall: () -> Unit = {},

    onShare: () -> Unit = {}

) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onSelect()
            },

        shape = RoundedCornerShape(18.dp),

        border = BorderStroke(
            1.dp,
            CardBorder
        ),

        colors = CardDefaults.cardColors(
            containerColor = CardSurface
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )

    ) {

        Column(

            modifier = Modifier.padding(18.dp)

        ) {

            Row(

                verticalAlignment = Alignment.CenterVertically

            ) {

                NumberIcon(item.type)

                Spacer(Modifier.width(12.dp))

                Column(

                    modifier = Modifier.weight(1f)

                ) {

                    Text(

                        text = item.value,

                        style = MaterialTheme.typography.titleMedium

                    )

                    Spacer(Modifier.height(4.dp))
                    NumberBadge(item.type)

                }

            }

            Spacer(Modifier.height(16.dp))

            HorizontalDivider(
                color = DividerColor
            )

            Spacer(Modifier.height(10.dp))

            Row(

                horizontalArrangement = Arrangement.SpaceEvenly,

                modifier = Modifier.fillMaxWidth()

            ) {

                ActionButton(

                    icon = Icons.Rounded.Call,

                    text = "تماس",

                    onClick = onCall

                )

                ActionButton(

                    icon = Icons.Rounded.ContentCopy,

                    text = "کپی",

                    onClick = onCopy

                )

                ActionButton(

                    icon = Icons.Rounded.Share,

                    text = "اشتراک",

                    onClick = onShare

                )

            }

        }

    }

}

@Composable
private fun ActionButton(

    icon: androidx.compose.ui.graphics.vector.ImageVector,

    text: String,

    onClick: () -> Unit

) {

    Column(

        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = Modifier.clip(CircleShape)

    ) {

        IconButton(

            onClick = onClick

        ) {

            Icon(

                imageVector = icon,

                contentDescription = null

            )

        }

        Text(

            text = text,

            style = MaterialTheme.typography.bodySmall

        )

    }

}
