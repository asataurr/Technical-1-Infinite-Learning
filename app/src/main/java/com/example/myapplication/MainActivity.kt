// MainActivity.kt
package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "screen1",
            Modifier.padding(innerPadding)
        ) {
            composable("screen1") { Screen1(navController) }
            composable("screen2") { Screen2(navController) }
            composable("screen3") { AboutScreen() }
            composable("detail/{nama}/{deskripsi}") { backStackEntry ->
                val nama = backStackEntry.arguments?.getString("nama")
                val deskripsi = backStackEntry.arguments?.getString("deskripsi")
                DetailScreen(nama, deskripsi, navController)

                val namaKelas = backStackEntry.arguments?.getString("nama")
                val deskripsiKelas = backStackEntry.arguments?.getString("deskripsi")
                DetailScreenKelas(namaKelas, deskripsiKelas, navController)
            }
        }
    }
}

