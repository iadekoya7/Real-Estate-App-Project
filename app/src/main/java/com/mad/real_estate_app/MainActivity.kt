package com.mad.real_estate_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import com.mad.real_estate_app.presentation.Navigation
import com.mad.real_estate_app.ui.theme.Real_Estate_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Real_Estate_AppTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Navigation(navController = navController)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Real_Estate_AppTheme {
        Greeting("Android")
    }
}