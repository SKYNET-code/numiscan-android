package com.numiscan.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.numiscan.app.ui.theme.CardBorder
import com.numiscan.app.ui.theme.Surface

@Composable
fun InputCard(

    text: String,

    onTextChange: (String) -> Unit,

    onExtract: () -> Unit,

    onPaste: () -> Unit,

    onClear: () -> Unit

) {

    Card(

        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(18.dp),

        border = BorderStroke(

            1.dp,

            CardBorder

        ),

        elevation = CardDefaults.cardElevation(

            defaultElevation = 6.dp

        ),

        colors = CardDefaults.cardColors(

            containerColor = Surface

        )

    ) {

        Column(

            modifier = Modifier.padding(18.dp),

            verticalArrangement = Arrangement.spacedBy(14.dp)

        ) {

            Text(

                "متن پیامک یا متن دلخواه",

                style = MaterialTheme.typography.titleMedium

            )

            OutlinedTextField(

                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),

                value = text,

                onValueChange = onTextChange,

                placeholder = {

                    Text("پیامک یا متن را اینجا وارد کنید...")

                }

            )

            Button(

                modifier = Modifier.fillMaxWidth(),

                onClick = onExtract

            ) {

                Text("استخراج شماره‌ها")

            }

        }

    }

}
