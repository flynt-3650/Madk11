// app/src/main/java/com/example/madk11/MainActivity.kt
package com.example.madk11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val workRequest: WorkRequest = OneTimeWorkRequestBuilder<MyWorker>().build()
        WorkManager.getInstance(applicationContext).enqueue(workRequest)
        setContent {
            val navController = rememberNavController()
            AppNavHost(navController)
        }
    }
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen { navController.navigate("detail") } }
        composable("detail") { DetailScreen() }
    }
}

@Composable
fun HomeScreen(onNavigate: () -> Unit) {
    Column {
        Button(onClick = onNavigate) {
            Text("Go to Detail")
        }
    }
}

@Composable
fun DetailScreen() {
    Text("Detail Screen")
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen {}
}
