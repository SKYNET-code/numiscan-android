package com.numiscan.app.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun SearchBar(

    query: String,

    onQueryChange: (String) -> Unit

) {


    OutlinedTextField(

        value = query,

        onValueChange = onQueryChange,

        modifier = Modifier.fillMaxWidth(),

        singleLine = true,

        label = {

            Text("جستجو در نتایج")

        },

        placeholder = {

            Text("مثلا 0912")

        }

    )

}
