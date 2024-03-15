package com.example.myapplicationii.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeintroducao.datastore.AppDataStore
import com.example.myapplicationii.datastore.AppDataStoreKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(
    private val appDataStore: AppDataStore
): ViewModel(){
    val autenticado = mutableStateOf(false)


    fun login(
        usuario: String,
        senha: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        if (usuario.isEmpty()) {
            onError("Informe o usuário")
            return
        }

        if (usuario.isEmpty()) {
            onError("Informe a senha")
            return
        }

        viewModelScope.launch {
            appDataStore.putBoolean(AppDataStoreKeys.AUTENTICADO, true).apply {
                onSuccess()
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            appDataStore.putBoolean(AppDataStoreKeys.AUTENTICADO, false)
        }
    }


}