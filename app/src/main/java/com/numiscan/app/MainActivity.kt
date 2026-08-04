package com.numiscan.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.numiscan.app.navigation.AppNavigation
import com.numiscan.app.ui.theme.NumiScanTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(

        savedInstanceState: Bundle?

    ) {

        super.onCreate(savedInstanceState)

        setContent {

            NumiScanTheme {

                AppNavigation()

            }

        }

    }

}
