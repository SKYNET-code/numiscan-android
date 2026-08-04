package com.numiscan.app.ui.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier



@Composable
fun SearchBar(

    value:String,

    onValueChange:(String)->Unit

){


    OutlinedTextField(

        value = value,

        onValueChange = onValueChange,

        modifier =
            Modifier.fillMaxWidth(),

        label = {

            Text("جستجو")

        }

    )

}
