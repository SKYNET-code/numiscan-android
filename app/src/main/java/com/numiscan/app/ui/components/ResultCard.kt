package com.numiscan.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.ExtractedNumber

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
            .clickable {
                onSelect()
            },

        shape = RoundedCornerShape(18.dp),

        border = BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.outlineVariant
        ),

        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )

    ) {

        Column(

            modifier = Modifier.padding(16.dp)

        ) {

            Row(

                verticalAlignment = Alignment.CenterVertically

            ) {

                NumberIcon(item.type)

                Spacer(Modifier.width(10.dp))

                NumberBadge(item.type)

                Spacer(Modifier.weight(1f))

                Checkbox(

                    checked = item.selected,

                    onCheckedChange = {

                        onSelect()

                    }

                )

            }

            Spacer(Modifier.height(14.dp))

            Text(

                text = item.value,

                style = MaterialTheme.typography.titleMedium

            )

            Spacer(Modifier.height(14.dp))

            Row(

                horizontalArrangement = Arrangement.End,

                modifier = Modifier.fillMaxWidth()

            ) {

                IconButton(

                    onClick = {

                        onCopy?.invoke()

                    }

                ) {

                    Icon(

                        Icons.Outlined.ContentCopy,

                        null

                    )

                }

                IconButton(

                    onClick = {

                        onShare?.invoke()

                    }

                ) {

                    Icon(

                        Icons.Outlined.Share,

                        null

                    )

                }

                IconButton(

                    onClick = {

                        onCall?.invoke()

                    }

                ) {

                    Icon(

                        Icons.Outlined.Call,

                        null

                    )

                }

            }

        }

    }

}
