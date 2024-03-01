package com.example.myapplicationii.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.compose.AsyncImagePainter
import com.example.myapplicationii.datastore.AppDataStore
import com.example.myapplicationii.datastore.AppDataStoreKey
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Error
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(
    private val appDataStore: AppDataStore
): ViewModel() {
    val autenticado = mutableStateOf(false)

    fun login(
        usuario: String,
        senha: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    )   {
        if (usuario.isEmpty()){
            onError("Informe o Usuário")
            return
        }

        if (senha.isEmpty()){
            onError("Informe a Senha")
            return
        }

        //chamada API

        viewModelScope.launch {
            appDataStore.putBoolean(AppDataStoreKeys.AUTENTICADO, true).apply {
                onSuccess()
            }
        }
    }
    fun logout(){

    }
}