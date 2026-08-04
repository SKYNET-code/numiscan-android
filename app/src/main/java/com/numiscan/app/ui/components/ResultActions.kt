package com.numiscan.app.ui.components

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun ResultActions(

    value: String

) {

    val context = LocalContext.current


    Row(

        modifier = Modifier.fillMaxWidth(),

        horizontalArrangement = Arrangement.spacedBy(8.dp),

        verticalAlignment = Alignment.CenterVertically

    ) {

        TextButton(

            onClick = {

                val clipboard =
                    context.getSystemService(android.content.Context.CLIPBOARD_SERVICE)
                            as android.content.ClipboardManager

                clipboard.setPrimaryClip(

                    android.content.ClipData.newPlainText(

                        "number",

                        value

                    )

                )

            }

        ) {

            Icon(

                imageVector = Icons.Outlined.ContentCopy,

                contentDescription = null

            )

            Text(

                text = "کپی"

            )

        }


        TextButton(

            onClick = {

                val intent = Intent(

                    Intent.ACTION_DIAL

                ).apply {

                    data =
                        android.net.Uri.parse("tel:$value")

                }

                context.startActivity(intent)

            }

        ) {

            Icon(

                imageVector = Icons.Outlined.Call,

                contentDescription = null

            )

            Text(

                text = "تماس"

            )

        }
                TextButton(

            onClick = {

                val sendIntent = Intent(

                    Intent.ACTION_SEND

                ).apply {

                    putExtra(

                        Intent.EXTRA_TEXT,

                        value

                    )

                    type = "text/plain"

                }


                val shareIntent = Intent.createChooser(

                    sendIntent,

                    null

                )


                context.startActivity(

                    shareIntent

                )

            }

        ) {

            Icon(

                imageVector = Icons.Outlined.Share,

                contentDescription = null

            )


            Text(

                text = "اشتراک"

            )

        }

    }

}
