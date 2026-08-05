package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ContentPaste
import androidx.compose.material.icons.outlined.DeleteOutline
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight

@Composable
fun InputCard(

    text: String,

    onTextChange: (String) -> Unit,

    modifier: Modifier = Modifier

) {

    val clipboardManager = LocalClipboardManager.current

    Card(

        modifier = modifier.fillMaxWidth(),

        shape = RoundedCornerShape(16.dp),

        colors = CardDefaults.cardColors(

            containerColor = MaterialTheme.colorScheme.surface

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

                        text = "متن، پیام، شماره‌ها یا اطلاعات را اینجا وارد کنید...",

                        modifier = Modifier.fillMaxWidth(),

                        textAlign = TextAlign.End

                    )

                },

                textStyle = MaterialTheme.typography.bodyLarge.copy(

                    textAlign = TextAlign.End,

                    textDirection = TextDirection.ContentOrRtl

                ),

                shape = RoundedCornerShape(16.dp),

                singleLine = false,

                maxLines = 12,

                colors = OutlinedTextFieldDefaults.colors(

                    focusedBorderColor = MaterialTheme.colorScheme.primary,

                    unfocusedBorderColor = MaterialTheme.colorScheme.outline,

                    focusedContainerColor = MaterialTheme.colorScheme.surface,

                    unfocusedContainerColor = MaterialTheme.colorScheme.surface

                )

            )

            Spacer(

                modifier = Modifier.height(16.dp)

            )

            Row(

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End)

            ) {

                Button(

                    onClick = {

                        val clipboardText = clipboardManager.getText()

                        if (clipboardText != null) {

                            onTextChange(clipboardText.text)

                        }

                    },

                    shape = RoundedCornerShape(12.dp)

                ) {

                    androidx.compose.material3.Icon(

                        imageVector = Icons.Outlined.ContentPaste,

                        contentDescription = null

                    )

                    Spacer(

                        modifier = Modifier.width(6.dp)

                    )

                    Text(

                        "چسباندن"

                    )

                }

                Button(

                    onClick = {

                        onTextChange("")

                    },

                    shape = RoundedCornerShape(12.dp)

                ) {

                    androidx.compose.material3.Icon(

                        imageVector = Icons.Outlined.DeleteOutline,

                        contentDescription = null

                    )

                    Spacer(

                        modifier = Modifier.width(6.dp)

                    )

                    Text(

                        "پاک کردن"

                    )

                }

            }

        }

    }

}
