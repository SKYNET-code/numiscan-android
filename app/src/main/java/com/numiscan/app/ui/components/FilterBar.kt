package com.numiscan.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.numiscan.app.data.model.NumberType

@Composable
fun FilterBar(

    selectedType: NumberType?,

    onTypeSelected: (NumberType?) -> Unit,

    modifier: Modifier = Modifier

) {


    Row(

        modifier = modifier

            .fillMaxWidth()

            .padding(vertical = 8.dp),

        horizontalArrangement = Arrangement.spacedBy(8.dp)

    ) {


        FilterChip(

            selected = selectedType == null,

            onClick = {

                onTypeSelected(null)

            },

            label = {

                Text("همه")

            },

            colors = FilterChipDefaults.filterChipColors(

                selectedContainerColor =
                    MaterialTheme.colorScheme.primaryContainer,

                selectedLabelColor =
                    MaterialTheme.colorScheme.onPrimaryContainer

            )

        )


        FilterChip(

            selected = selectedType == NumberType.MOBILE,

            onClick = {

                onTypeSelected(NumberType.MOBILE)

            },

            label = {

                Text("موبایل")

            },

            colors = FilterChipDefaults.filterChipColors(

                selectedContainerColor =
                    MaterialTheme.colorScheme.primaryContainer,

                selectedLabelColor =
                    MaterialTheme.colorScheme.onPrimaryContainer

            )

        )


        FilterChip(

            selected = selectedType == NumberType.LANDLINE,

            onClick = {

                onTypeSelected(NumberType.LANDLINE)

            },

            label = {

                Text("ثابت")

            },

            colors = FilterChipDefaults.filterChipColors(

                selectedContainerColor =
                    MaterialTheme.colorScheme.primaryContainer,

                selectedLabelColor =
                    MaterialTheme.colorScheme.onPrimaryContainer

            )

        )


        FilterChip(

            selected = selectedType == NumberType.BANK_CARD,

            onClick = {

                onTypeSelected(NumberType.BANK_CARD)

            },

            label = {

                Text("کارت بانکی")

            },

            colors = FilterChipDefaults.filterChipColors(

                selectedContainerColor =
                    MaterialTheme.colorScheme.primaryContainer,

                selectedLabelColor =
                    MaterialTheme.colorScheme.onPrimaryContainer

            )

        )

    }

}
