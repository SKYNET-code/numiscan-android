package com.numiscan.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.ExtractedNumber

@Composable
fun ResultCard(

    item: ExtractedNumber,

    onSelect: () -> Unit,

    onCopy: () -> Unit,

    onCall: () -> Unit,

    onShare: () -> Unit

) {

    Card(

        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(

            containerColor = MaterialTheme.colorScheme.surfaceVariant

        ),

        elevation = CardDefaults.cardElevation(

            defaultElevation = 3.dp

        )

    ) {

        Column(

            modifier = Modifier.padding(18.dp)

        ) {

            Row(

                verticalAlignment = Alignment.CenterVertically

            ) {

                Checkbox(

                    checked = item.selected,

                    onCheckedChange = {

                        onSelect()

                    }

                )

                Spacer(

                    modifier = Modifier.width(8.dp)

                )

                NumberBadge(

                    type = item.type

                )

            }

            Spacer(

                modifier = Modifier.height(14.dp)

            )

            Text(

                text = item.value,

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.Bold

            )

            Spacer(

                modifier = Modifier.height(16.dp)

            )

            Divider()

            Spacer(

                modifier = Modifier.height(8.dp)

            )

            Row(

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceEvenly

            ) {

                IconButton(

                    onClick = onCopy

                ) {

                    Icon(

                        Icons.Outlined.ContentCopy,

                        null

                    )

                }

                IconButton(

                    onClick = onCall

                ) {

                    Icon(

                        Icons.Outlined.Call,

                        null

                    )

                }

                IconButton(

                    onClick = onShare

                ) {

                    Icon(

                        Icons.Outlined.Share,

                        null

                    )

                }

            }

        }

    }

}
