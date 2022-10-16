package com.neotica.lazylist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.neotica.dicoding2.ProfileActivity
import com.neotica.dicoding2.R
import com.neotica.lazylist.data.model.PersonEntity
import com.neotica.dicoding2.ui.theme.Dicoding2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Dicoding2Theme {
                // A surface container using the 'background' color from the theme
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
            BarkHomeContent(navigateToProfile = navigateToProfile)
        }
    )
}

@Composable
fun Topbar1(){
    Column {
        TopAppBar(
            title = {
                Text(text = "Home")
            },

            actions = {
                val context = LocalContext.current
                Image(
                    painter = painterResource(R.drawable.ic_profile), contentDescription = null,
                    modifier = Modifier
                        .clickable { context.startActivity(Intent(context, DicodingProfile::class.java)) }
                        .padding(8.dp)
                        .size(84.dp)
                        .clip(RoundedCornerShape(corner = CornerSize(16.dp)))

                )

                }
        )

    }
}

@Composable
fun Topbar2(){
    Column {
        TopAppBar(
            title = {
               // Text(text = "Home")
            },

            navigationIcon = {
                val context = LocalContext.current as? Activity
                Image(
                    painter = painterResource(R.drawable.back), contentDescription = null,
                    modifier = Modifier
                        .clickable { context?.finish() }
                        .padding(8.dp)
                        .size(84.dp)
                        .clip(RoundedCornerShape(corner = CornerSize(16.dp)))

                )

            }
        )

    }
}

/*
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    }
}*/
