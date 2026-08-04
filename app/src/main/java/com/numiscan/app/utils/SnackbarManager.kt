package com.numiscan.app.utils


import androidx.compose.material3.SnackbarHostState


object SnackbarManager {


    suspend fun show(

        snackbarHostState: SnackbarHostState,

        message: String

    ){

        snackbarHostState.showSnackbar(

            message

        )

    }

}
