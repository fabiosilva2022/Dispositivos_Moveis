package com.example.myapplicationii

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeintroduoaula.ui.MinhaContaScreen
import com.example.myapplicationii.ui.theme.InicioScreen
import com.example.myapplicationii.ui.theme.LoginScreen
import com.example.myapplicationii.ui.theme.MyApplicationIITheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MyApplicationIITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    NavHost(
                        navController = navController,
                        startDestination = "minhaconta"
                    ){
                        composable("inicio"){
                            InicioScreen(navController)
                        }
                        composable("login"){
                            LoginScreen(navController)
                        }
                        composable("minhaconta"){
                            MinhaContaScreen(navController)
                        }
                    }
                }
            }
        }


    }
}

