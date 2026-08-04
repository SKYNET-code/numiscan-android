package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.ContentPaste
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun InputCard(

    text: String,

    onTextChange: (String) -> Unit,

    onExtract: () -> Unit,

    onPaste: () -> Unit,

    onClear: () -> Unit

) {

    ElevatedCard(

        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(24.dp),

        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 6.dp
        )

    ) {

        Column(

            modifier = Modifier.padding(20.dp)

        ) {

            Text(

                text = "متن ورودی",

                style = MaterialTheme.typography.titleMedium

            )

            Spacer(
                Modifier.height(14.dp)
            )

            OutlinedTextField(

                value = text,

                onValueChange = onTextChange,

                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),

                shape = RoundedCornerShape(18.dp),

                placeholder = {

                    Text(

                        "پیامک، متن، شماره‌ها یا هر اطلاعاتی را اینجا وارد یا جای‌گذاری کنید.",

                        textAlign = TextAlign.Start

                    )

                }

            )

            Spacer(
                Modifier.height(18.dp)
            )

            Row(

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.spacedBy(12.dp)

            ) {

                FilledTonalButton(

                    modifier = Modifier.weight(1f),

                    onClick = onPaste

                ) {

                    Icon(

                        Icons.Outlined.ContentPaste,

                        contentDescription = null

                    )

                    Spacer(
                        Modifier.width(8.dp)
                    )

                    Text("چسباندن")

                }

                FilledTonalButton(

                    modifier = Modifier.weight(1f),

                    onClick = onClear

                ) {

                    Icon(

                        Icons.Outlined.Clear,

                        contentDescription = null

                    )

                    Spacer(
                        Modifier.width(8.dp)
                    )

                    Text("پاک کردن")

                }

            }

            Spacer(
                Modifier.height(18.dp)
            )

            Button(

                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),

                shape = RoundedCornerShape(16.dp),

                onClick = onExtract

            ) {

                Icon(

                    Icons.Outlined.Search,

                    contentDescription = null

                )

                Spacer(
                    Modifier.width(8.dp)
                )

                Text(

                    "استخراج شماره‌ها"

                )

            }

        }

    }

}
