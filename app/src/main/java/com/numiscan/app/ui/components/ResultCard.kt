package com.numiscan.app.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.ExtractedNumber
import com.numiscan.app.data.model.NumberType
import com.numiscan.app.utils.ClipboardManager
import com.numiscan.app.utils.ShareManager

@Composable
fun ResultCard(

    item: ExtractedNumber,

    onSelect: () -> Unit

) {

    val context = LocalContext.current

    Card(

        modifier = Modifier
            .fillMaxWidth(),

        shape = RoundedCornerShape(18.dp),

        colors = CardDefaults.cardColors(

            containerColor = MaterialTheme.colorScheme.surfaceVariant

        ),

        elevation = CardDefaults.cardElevation(4.dp)

    ) {

        Column(

            modifier = Modifier.padding(16.dp)

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

                Spacer(Modifier.width(8.dp))

                NumberBadge(item.type)

            }

            Spacer(Modifier.height(10.dp))

            Text(

                text = item.value,

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.Bold

            )

            Spacer(Modifier.height(12.dp))

            HorizontalDivider()

            Spacer(Modifier.height(8.dp))

            Row(

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceEvenly

            ) {

                IconButton(

                    onClick = {

                        ClipboardManager.copy(

                            context,

                            item.value

                        )

                    }

                ) {

                    Icon(

                        Icons.Outlined.ContentCopy,

                        null

                    )

                }

                IconButton(

                    onClick = {

                        ShareManager.share(

                            context,

                            item.value

                        )

                    }

                ) {

                    Icon(

                        Icons.Outlined.Share,

                        null

                    )

                }

                if (

                    item.type == NumberType.MOBILE ||

                    item.type == NumberType.LANDLINE

                ) {

                    IconButton(

                        onClick = {

                            context.startActivity(

                                Intent(

                                    Intent.ACTION_DIAL,

                                    Uri.parse("tel:${item.value}")

                                )

                            )

                        }

                    ) {

                        Icon(

                            Icons.Outlined.Call,

                            null

                        )

                    }

                }

                if (

                    item.type == NumberType.MOBILE

                ) {

                    IconButton(

                        onClick = {

                            context.startActivity(

                                Intent(

                                    Intent.ACTION_SENDTO,

                                    Uri.parse("smsto:${item.value}")

                                )

                            )

                        }

                    ) {

                        Icon(

                            Icons.Outlined.Message,

                            null

                        )

                    }

                }

            }

        }

    }

}
