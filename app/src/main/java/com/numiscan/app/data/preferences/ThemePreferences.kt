package com.numiscan.app.data.preferences

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


private val Context.dataStore by preferencesDataStore(
    name = "settings"
)


class ThemePreferences(
    private val context: Context
) {


    private val darkModeKey =
        booleanPreferencesKey("dark_mode")



    val darkMode: Flow<Boolean> =

        context.dataStore.data.map {

            preferences ->

            preferences[darkModeKey] ?: false

        }



    suspend fun setDarkMode(

        enabled: Boolean

    ){

        context.dataStore.edit {

            settings ->

            settings[darkModeKey] = enabled

        }

    }

}
