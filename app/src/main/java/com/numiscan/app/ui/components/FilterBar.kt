package com.numiscan.app.ui.components


import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.FilterType



@Composable
fun FilterBar(

    selected: FilterType,

    onSelected: (FilterType) -> Unit

){


    Row(

        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(
                rememberScrollState()
            ),

        horizontalArrangement =
            Arrangement.spacedBy(8.dp)

    ){


        FilterType.entries.forEach { type ->


            FilterChip(

                selected =
                    selected == type,


                onClick = {

                    onSelected(type)

                },


                label = {

                    Text(

                        when(type){

                            FilterType.ALL ->
                                "همه"


                            FilterType.MOBILE ->
                                "موبایل"


                            FilterType.LANDLINE ->
                                "تلفن ثابت"


                            FilterType.BANK_CARD ->
                                "کارت بانکی"

                        }

                    )

                }

            )

        }

    }

}
