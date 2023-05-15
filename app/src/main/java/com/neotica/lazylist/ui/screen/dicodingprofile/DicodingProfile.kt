package com.neotica.lazylist.ui.screen.dicodingprofile

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.neotica.dicoding2.R
import com.neotica.dicoding2.ui.theme.Dicoding2Theme
import com.neotica.lazylist.ui.theme.baselineHeight

class DicodingProfile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            rememberScrollState()
            Dicoding2Theme {
                // A surface container using the 'background' color from the theme
                Scaffold() {
                    Column(
                       horizontalAlignment = Alignment.CenterHorizontally,
                       verticalArrangement = Arrangement.Center
                    ) {
                        TopBarProfile()
                        Column(horizontalAlignment = CenterHorizontally) {
                            Box(contentAlignment = Center) { ProfPic() }
                            Divider()
                            Text(
                                text = "Nama: ",
                                modifier = Modifier.baselineHeight(24.dp),
                                style = MaterialTheme.typography.caption
                            )
                            Text(
                                text = "Ryo Martin Sopian",
                                modifier = Modifier.baselineHeight(28.dp),
                                style = MaterialTheme.typography.h5,
                                fontWeight = FontWeight.Bold,
                            )
                            Divider()
                            Text(
                                text = "Email: ",
                                modifier = Modifier.baselineHeight(24.dp),
                                style = MaterialTheme.typography.caption
                            )
                            Text(
                                text = "laetuzg@gmail.com",
                                modifier = Modifier.baselineHeight(28.dp),
                                style = MaterialTheme.typography.h5,
                                fontWeight = FontWeight.Bold,
                            )
                            Divider()
                        }
                    }
                }
            }
        }
    }
}


@Composable
private fun ProfPic() {
    Image(
        painter = painterResource(R.drawable.profpic2),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(20.dp)
            .size(200.dp)
            .clip(RoundedCornerShape(corner = CornerSize(100.dp)))
    )
}

@Composable
fun TopBarProfile() {
    Column {
        TopAppBar(
            title = {
                Text(text = "About Page")
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