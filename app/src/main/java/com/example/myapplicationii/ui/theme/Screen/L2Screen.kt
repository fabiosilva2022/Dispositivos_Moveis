package com.example.myapplicationii.ui.theme.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationii.R
import com.example.myapplicationii.ui.theme.Theme.MyApplicationIITheme
import com.example.myapplicationii.viewmodel.AuthViewModel


@Composable
fun L2Screen(
    navController: NavController
) {
    val authViewModel = hiltViewModel<AuthViewModel>()
    var usuario by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ifro_campus_vertical),
                contentDescription = "Logo IFRO",
                modifier = Modifier.size(150.dp)
            )

            if (error.isNotBlank()) {
                Text(error)
            }

            OutlinedTextField(
                value = usuario,
                onValueChange = { usuario = it},
                label = { Text(text = "Usuario") }
            )

            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it},
                label = { Text(text = "Senha") }
            )

            Button(
                onClick = {
                    authViewModel.login(
                        usuario,
                        senha,
                        onSuccess = {
                            navController.navigate("minhaconta")
                        },
                        onError = { message ->
                            error = message
                        }
                    )
                },
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .padding(top = 24.dp)
                    .size(width = 200.dp, height = 50.dp),
                colors = ButtonDefaults.run { val buttonColors =
                    buttonColors(Color(0xFFB16741))
                    buttonColors
                }

            ) {
                Text("Entrar")
            }
        }
    }
}

@Preview
@Composable
fun L2ScreenPreview() {
    MaterialTheme {
        L2Screen(rememberNavController())
    }
}