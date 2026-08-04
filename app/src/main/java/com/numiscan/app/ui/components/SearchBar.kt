package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(

    query: String,

    onQueryChange: (String) -> Unit

) {

    OutlinedTextField(

        value = query,

        onValueChange = onQueryChange,

        modifier = Modifier
            .fillMaxWidth()
            .height(58.dp),

        shape = RoundedCornerShape(16.dp),

        singleLine = true,

        leadingIcon = {

            Icon(

                imageVector = Icons.Outlined.Search,

                contentDescription = null

            )

        },

        placeholder = {

            Text(

                "جستجو بین نتایج"

            )

        },

        textStyle = MaterialTheme.typography.bodyLarge

    )

}
