package com.example.myapplicationii.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey


object AppDataStoreKeys {
    val AUTENTICADO = booleanPreferencesKey("autenticado")
    val NOME = stringPreferencesKey("nome")
}