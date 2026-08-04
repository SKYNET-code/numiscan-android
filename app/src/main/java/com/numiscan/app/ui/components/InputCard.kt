package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ContentPaste
import androidx.compose.material.icons.outlined.DeleteOutline
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun InputCard(

    text: String,

    onTextChange: (String) -> Unit,

    modifier: Modifier = Modifier

) {

    Card(

        modifier = modifier.fillMaxWidth(),

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(

            containerColor = Color.White

        ),

        elevation = CardDefaults.cardElevation(

            defaultElevation = 2.dp

        )

    ) {

        Column(

            modifier = Modifier.padding(18.dp)

        ) {

            Text(

                text = "متن ورودی",

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.Bold

            )

            Spacer(

                modifier = Modifier.height(12.dp)

            )

            OutlinedTextField(

                value = text,

                onValueChange = onTextChange,

                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 180.dp),

                placeholder = {

                    Text(

                        "متن، پیام، شماره‌ها یا اطلاعات را اینجا وارد یا Paste کنید..."

                    )

                },

                shape = RoundedCornerShape(16.dp),

                singleLine = false,

                maxLines = 12
