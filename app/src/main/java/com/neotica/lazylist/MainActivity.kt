package com.neotica.lazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.neotica.dicoding2.ui.theme.Dicoding2Theme
import com.neotica.lazylist.data.model.PersonEntity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Dicoding2Theme {
                MyApp {
                    startActivity(ProfileActivity.newIntent(this, it))
                }
            }
        }
    }
}

@Composable
fun MyApp(navigateToProfile: (PersonEntity) -> Unit) {
    Scaffold(
        content = {
            HomeScreen(navigateToProfile = navigateToProfile)
        }
    )
}