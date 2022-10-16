package com.neotica.lazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neotica.dicoding2.R
import com.neotica.lazylist.data.model.PersonEntity
import com.neotica.dicoding2.ui.theme.Dicoding2Theme

class DicodingProfile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scrollState = rememberScrollState()
            Dicoding2Theme {
                // A surface container using the 'background' color from the theme
                Column(modifier = Modifier.fillMaxSize()) {
                    Topbar2()
                    BoxWithConstraints(
                        Modifier
                            .height(685.dp)
                            .align(CenterHorizontally)
                            .background(androidx.compose.ui.graphics.Color.Black)) {

                            Column(modifier = Modifier
                                .fillMaxSize()
                                .verticalScroll(ScrollState(1)),
                            horizontalAlignment = CenterHorizontally
                                ) {
                                Box(
                                    Modifier
                                        .height(690.dp)
                                ){
                                    Column(horizontalAlignment = CenterHorizontally) {
                                        Box(contentAlignment = TopCenter){ ProfPic() }

                                        Box(modifier = Modifier.padding(20.dp)) {
                                            Text(
                                                modifier = Modifier.height(10.dp).padding(10.dp).aspectRatio(5.5f),
                                                text = "Nama: ",
                                                color = androidx.compose.ui.graphics.Color.White,
                                                fontSize = 18.sp,
                                                textAlign = TextAlign.Left
                                            )
                                            Text(
                                                text = "Ryo Martin Sopian",
                                                color = androidx.compose.ui.graphics.Color.White,
                                                fontSize = 30.sp,
                                            )
                                        }

                                        Box(modifier = Modifier.padding(20.dp)) {
                                            Text(
                                                modifier = Modifier.height(10.dp).padding(10.dp).aspectRatio(5.5f),
                                                text = "Email: ",
                                                color = androidx.compose.ui.graphics.Color.White,
                                                fontSize = 18.sp,
                                                textAlign = TextAlign.Left
                                            )
                                            Text(
                                                text = "laetuzg@gmail.com",
                                                color = androidx.compose.ui.graphics.Color.White,
                                                fontSize = 30.sp,
                                            )
                                        }
                                    }


                }

                    }

                        }
                    }
                }
                //SAMPE SINI
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
            .clip(RoundedCornerShape(corner = CornerSize(100.dp))),
        //alignment = Alignment.TopCenter,

    )
}

@Composable
private fun ProfileHeader(
    scrollState: ScrollState,
    puppy: PersonEntity,
    containerHeight: Dp
) {
    val offset = (scrollState.value / 2)
    val offsetDp = with(LocalDensity.current) { offset.toDp() }

    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth()
            .padding(top = offsetDp),
        painter = painterResource(id = puppy.personImageId),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
private fun ProfileContent(puppy: PersonEntity, containerHeight: Dp) {
    Column {
        Spacer(modifier = Modifier.height(8.dp))

        Name(puppy)

        ProfileProperty2(stringResource(R.string.sex), puppy.sex)

        ProfileProperty2(stringResource(R.string.age), puppy.age.toString())

        ProfileProperty2(stringResource(R.string.personality), puppy.description)

        // Add a spacer that always shows part (320.dp) of the fields list regardless of the device,
        // in order to always leave some content at the top.
        Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
private fun Name(
) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {

            Text(text = "One")

    }
}

@Composable
private fun Name(puppy: PersonEntity, modifier: Modifier = Modifier) {
    Text(
        text = puppy.title,
        modifier = modifier,
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ProfileProperty2(label: String, value: String, isLink: Boolean = false) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider()
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = label,
                modifier = Modifier.baselineHeight(24.dp),
                style = MaterialTheme.typography.caption,
            )
        }
        val style = if (isLink) {
            MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.primary)
        } else {
            MaterialTheme.typography.body1
        }
        Text(
            text = value,
            modifier = Modifier.baselineHeight(24.dp),
            style = style
        )
    }
}