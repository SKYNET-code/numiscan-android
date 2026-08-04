package com.numiscan.app.ui.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun ResultToolbar(

    onSelectAll: () -> Unit,

    onClear: () -> Unit

) {


    Row(

        modifier = Modifier.fillMaxWidth(),

        horizontalArrangement =
            Arrangement.spacedBy(8.dp)

    ) {


        Button(

            onClick = onSelectAll

        ){

            Text("انتخاب همه")

        }



        Button(

            onClick = onClear

        ){

            Text("پاک کردن")

        }

    }

}
