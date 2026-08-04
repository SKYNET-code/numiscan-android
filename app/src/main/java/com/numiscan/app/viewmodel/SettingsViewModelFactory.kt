package com.numiscan.app.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.numiscan.app.data.preferences.ThemePreferences



class SettingsViewModelFactory(

    private val preferences: ThemePreferences

) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(

        modelClass: Class<T>

    ): T {


        if(

            modelClass.isAssignableFrom(
                SettingsViewModel::class.java
            )

        ){

            return SettingsViewModel(
                preferences
            ) as T

        }


        throw IllegalArgumentException(
            "Unknown ViewModel"
        )

    }

}
