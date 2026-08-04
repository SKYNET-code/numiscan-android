package com.numiscan.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
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

        modifier = Modifier
            .fillMaxWidth()
            .clickable {

                onSelect()

            },

        shape = RoundedCornerShape(22.dp),

        border = BorderStroke(

            1.dp,

            MaterialTheme.colorScheme.outlineVariant

        ),

        elevation = CardDefaults.cardElevation(

            defaultElevation = 4.dp

        ),

        colors = CardDefaults.cardColors(

            containerColor =
                MaterialTheme.colorScheme.surfaceVariant

        )

    ) {

        Column(

            modifier = Modifier.padding(18.dp)

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

            Spacer(Modifier.height(16.dp))

            Text(

                text = item.value,

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.Bold,

                maxLines = 2,

                overflow = TextOverflow.Ellipsis

            )

            Spacer(Modifier.height(8.dp))

            Text(

                text = typeDescription(item.type),

                style = MaterialTheme.typography.bodySmall,

                color = MaterialTheme.colorScheme.onSurfaceVariant

            )

            Spacer(Modifier.height(18.dp))

            HorizontalDivider()

            Spacer(Modifier.height(8.dp))

            Row(

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceEvenly

            ) {

                ActionButton(

                    text = "کپی",

                    icon = Icons.Outlined.ContentCopy,

                    onClick = onCopy

                )

                if (

                    item.type == NumberType.MOBILE ||

                    item.type == NumberType.PHONE

                ) {

                    ActionButton(

                        text = "تماس",

                        icon = Icons.Outlined.Call,

                        onClick = onCall

                    )

                }

                ActionButton(

                    text = "اشتراک",

                    icon = Icons.Outlined.Share,

                    onClick = onShare

                )

            }

        }

    }

}

private fun typeDescription(

    type: NumberType

): String {

    return when (type) {

        NumberType.MOBILE ->
            "شماره تلفن همراه"

        NumberType.PHONE ->
            "شماره تلفن ثابت"

        NumberType.CARD ->
            "شماره کارت بانکی"

        NumberType.SHABA ->
            "شماره شبا"

        NumberType.EMAIL ->
            "آدرس ایمیل"

        NumberType.URL ->
            "آدرس اینترنتی"

        NumberType.UNKNOWN ->
            "نوع نامشخص"

    }

}
