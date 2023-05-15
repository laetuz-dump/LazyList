package com.neotica.lazylist.ui.screen.homescreen

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.neotica.dicoding2.R
import com.neotica.lazylist.ui.screen.artists.PersonListItemView
import com.neotica.lazylist.data.DataProvider
import com.neotica.lazylist.data.model.PersonEntity
import com.neotica.lazylist.ui.screen.dicodingprofile.DicodingProfile

@Composable
fun HomeScreen(navigateToProfile: (PersonEntity) -> Unit) {
    val persons = remember { DataProvider.personList }
    Column {
        TopBarHome()
        Box(Modifier.fillMaxSize()) {
            Box(
                Modifier.align(Alignment.BottomCenter)
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    items(
                        items = persons,
                        itemContent = {
                            PersonListItemView(person = it, navigateToProfile)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun TopBarHome() {
    Column {
        TopAppBar(
            title = {
                Text(text = "Home")
            },
            actions = {
                val context = LocalContext.current
                Image(
                    painter = painterResource(R.drawable.ic_profile), contentDescription = "about_page",
                    modifier = Modifier
                        .clickable {
                            context.startActivity(
                                Intent(
                                    context,
                                    DicodingProfile::class.java
                                )
                            )
                        }
                        .padding(8.dp)
                        .size(84.dp)
                        .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                )
            }
        )
    }
}
