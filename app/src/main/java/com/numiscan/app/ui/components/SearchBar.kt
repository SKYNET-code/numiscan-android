package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(

    query: String,

    onQueryChange: (String) -> Unit,

    modifier: Modifier = Modifier

) {

    OutlinedTextField(

        value = query,

        onValueChange = onQueryChange,

        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),

        placeholder = {

            Text(

                text = "جستجو در نتایج..."

            )

        },

        leadingIcon = {

            Icon(

                imageVector = Icons.Outlined.Search,

                contentDescription = null

            )

        },

        singleLine = true,

        shape = RoundedCornerShape(18.dp),

        colors = OutlinedTextFieldDefaults.colors(

            focusedContainerColor = Color.White,

            unfocusedContainerColor = Color.White,

            focusedBorderColor = MaterialTheme.colorScheme.primary,

            unfocusedBorderColor = Color(0xFFD8DDE5)

        )

    )

}
