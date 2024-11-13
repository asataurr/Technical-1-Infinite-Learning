// BottomNavigationBar.kt
package com.example.myapplication

import androidx.compose.material3.* // Pastikan ini diimpor
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Apps // Gunakan Apps atau ikon lain
import androidx.compose.material.icons.filled.Info

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        NavigationBarItem(
            label = { Text("MATA KULIAH") },
            icon = { Icon(Icons.Filled.List, contentDescription = null) },
            selected = currentRoute == "screen1",
            onClick = { navController.navigate("screen1") }
        )
        NavigationBarItem(
            label = { Text("KELAS") },
            icon = { Icon(Icons.Filled.Apps, contentDescription = null) }, // Ganti dengan Apps
            selected = currentRoute == "screen2",
            onClick = { navController.navigate("screen2") }
        )
        NavigationBarItem(
            label = { Text("PROFILE") },
            icon = { Icon(Icons.Filled.Info, contentDescription = null) },
            selected = currentRoute == "screen3",
            onClick = { navController.navigate("screen3") }
        )
    }
}
