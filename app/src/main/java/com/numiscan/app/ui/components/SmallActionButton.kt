package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SmallActionButton(

    icon: ImageVector,

    text: String,

    onClick: () -> Unit

) {

    Column(

        modifier = Modifier
            .clickable {

                onClick()

            },

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center

    ) {

        Icon(

            imageVector = icon,

            contentDescription = text,

            modifier = Modifier.size(22.dp),

            tint = MaterialTheme.colorScheme.primary

        )

        Text(

            text = text,

            fontSize = 12.sp,

            color = MaterialTheme.colorScheme.onSurface

        )

    }

}
