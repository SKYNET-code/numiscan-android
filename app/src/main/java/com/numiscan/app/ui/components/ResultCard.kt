package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.*
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

    onCopy: () -> Unit,

    onCall: () -> Unit,

    onShare: () -> Unit

) {

    Card(

        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(18.dp),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),

        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
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
                    Modifier.width(10.dp)
                )

                NumberBadge(item.type)

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
                Modifier.height(18.dp)
            )

            HorizontalDivider()

            Spacer(
                Modifier.height(8.dp)
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

                        contentDescription = null

                    )

                }

                if (

                    item.type == NumberType.MOBILE ||

                    item.type == NumberType.PHONE

                ) {

                    IconButton(

                        onClick = onCall

                    ) {

                        Icon(

                            Icons.Outlined.Call,

                            contentDescription = null

                        )

                    }

                }

                if (

                    item.type != NumberType.UNKNOWN

                ) {

                    IconButton(

                        onClick = onShare

                    ) {

                        Icon(

                            Icons.Outlined.Share,

                            contentDescription = null

                        )

                    }

                }

            }

        }

    }

}
