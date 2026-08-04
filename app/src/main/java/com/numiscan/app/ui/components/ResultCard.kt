package com.numiscan.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.numiscan.app.data.model.ExtractedNumber

@Composable
fun ResultCard(

    item: ExtractedNumber,

    onSelect: () -> Unit

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
            Color(0xFFE3E7EE)
        ),

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

            Row(

                verticalAlignment = Alignment.CenterVertically

            ) {

                NumberIcon(item.type)

                Spacer(
                    Modifier.width(10.dp)
                )

                Column(
                    Modifier.weight(1f)
                ) {

                    Text(

                        text = item.value,

                        fontWeight = FontWeight.Bold,

                        fontSize = 18.sp,

                        maxLines = 1,

                        overflow = TextOverflow.Ellipsis

                    )

                    Spacer(
                        Modifier.height(4.dp)
                    )

                    NumberBadge(item.type)

                }

            }

            Spacer(
                Modifier.height(18.dp)
            )

            HorizontalDivider()

            Spacer(
                Modifier.height(12.dp)
            )

            Row(

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.SpaceEvenly

            ) {

                SmallActionButton(

                    icon = Icons.Outlined.ContentCopy,

                    text = "کپی"

                ) {

                }

                SmallActionButton(

                    icon = Icons.Outlined.Call,

                    text = "تماس"

                ) {

                }

                SmallActionButton(

                    icon = Icons.Outlined.Message,

                    text = "پیامک"

                ) {

                }

                SmallActionButton(

                    icon = Icons.Outlined.Share,

                    text = "اشتراک"

                ) {

                }

            }

        }

    }

}
