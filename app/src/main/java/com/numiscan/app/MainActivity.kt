package com.numiscan.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.numiscan.app.ui.theme.NumiScanTheme
import com.numiscan.app.ui.screens.HomeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            NumiScanTheme {

                Surface {

                    NumiScanApp()

                }

            }

        }
    }
}


@Composable
fun NumiScanApp() {

    HomeScreen()

}
