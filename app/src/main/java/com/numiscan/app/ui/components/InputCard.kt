package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ContentPaste
import androidx.compose.material.icons.outlined.DeleteOutline
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp

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

            modifier = Modifier.padding(16.dp)

        ) {

            OutlinedTextField(

                value = TextFieldValue(text),
                                onValueChange = {

                    onTextChange(it.text)

                },

                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 150.dp),

                placeholder = {

                    Text(

                        text = "متن، پیام، شماره‌ها یا اطلاعات را اینجا وارد کنید...",

                        modifier = Modifier.fillMaxWidth(),

                        textAlign = TextAlign.Right

                    )

                },

                textStyle = MaterialTheme.typography.bodyLarge.copy(

                    textAlign = TextAlign.Right,

                    textDirection = TextDirection.Rtl

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

                modifier = Modifier.height(14.dp)

            )

            Row(

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.Center,

                verticalAlignment = Alignment.CenterVertically

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

                    Icon(

                        imageVector = Icons.Outlined.ContentPaste,

                        contentDescription = null

                    )

                    Spacer(

                        modifier = Modifier.width(6.dp)

                    )

                    Text("چسباندن")

                }

                Spacer(

                    modifier = Modifier.width(12.dp)

                )
                                Button(

                    onClick = {

                        onTextChange("")

                    },

                    shape = RoundedCornerShape(12.dp)

                ) {

                    Icon(

                        imageVector = Icons.Outlined.DeleteOutline,

                        contentDescription = null

                    )

                    Spacer(

                        modifier = Modifier.width(6.dp)

                    )

                    Text("پاک کردن")

                }

            }

        }

    }

}
