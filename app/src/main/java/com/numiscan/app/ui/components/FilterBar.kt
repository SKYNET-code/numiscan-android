package com.numiscan.app.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.FilterType

@Composable
fun FilterBar(

    selected: FilterType,

    onSelected: (FilterType) -> Unit

) {

    Row(

        modifier = Modifier.horizontalScroll(

            rememberScrollState()

        ),

        horizontalArrangement = Arrangement.spacedBy(8.dp)

    ) {

        FilterType.entries.forEach { filter ->

            FilterChip(

                selected = filter == selected,

                onClick = {

                    onSelected(filter)

                },

                label = {

                    Text(

                        when (filter) {

                            FilterType.ALL -> "همه"

                            FilterType.MOBILE -> "موبایل"

                            FilterType.LANDLINE -> "ثابت"

                            FilterType.BANK_CARD -> "کارت"

                            FilterType.SHABA -> "شبا"

                        }

                    )

                },

                colors = FilterChipDefaults.filterChipColors()

            )

        }

    }

}
