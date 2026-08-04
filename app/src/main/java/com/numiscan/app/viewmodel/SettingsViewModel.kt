package com.numiscan.app.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.numiscan.app.data.preferences.ThemePreferences
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.launch



class SettingsViewModel(

    private val preferences: ThemePreferences

) : ViewModel(){



    val darkMode: StateFlow<Boolean> =

        preferences.darkMode.stateIn(

            viewModelScope,

            SharingStarted.WhileSubscribed(5000),

            false

        )



    fun changeTheme(

        value:Boolean

    ){

        viewModelScope.launch {

            preferences.setDarkMode(value)

        }

    }

}
