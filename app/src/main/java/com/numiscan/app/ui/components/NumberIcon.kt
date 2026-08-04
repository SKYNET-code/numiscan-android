package com.numiscan.app.ui.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.numiscan.app.data.model.NumberType



@Composable
fun NumberIcon(

    type: NumberType

){


    val icon: ImageVector = when (type) {

                NumberType.MOBILE -> Icons.Default.PhoneAndroid
            
                NumberType.LANDLINE -> Icons.Default.Call
            
                NumberType.BANK_CARD -> Icons.Default.CreditCard
            
                NumberType.SHABA -> Icons.Default.AccountBalance
            }


    Icon(

        imageVector = icon,

        contentDescription = null

    )


}
