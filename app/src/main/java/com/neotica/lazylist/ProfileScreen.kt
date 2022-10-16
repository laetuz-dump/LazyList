/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.neotica.lazylist

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.neotica.dicoding2.R
import com.neotica.lazylist.data.DataProvider
import com.neotica.lazylist.data.model.PersonEntity

@Composable
fun ProfileScreen(person: PersonEntity, onNavIconPressed: () -> Unit = { }) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize().background(color = Color.Black)) {
        BoxWithConstraints(modifier = Modifier.weight(1f)) {
            Topbar2()
            Box(Modifier.height(685.dp).align(Alignment.BottomCenter)){
                Surface {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(scrollState),
                    ) {
                        ProfileHeader(
                            scrollState,
                            person,
                            this@BoxWithConstraints.maxHeight
                        )
                        ProfileContent(person, this@BoxWithConstraints.maxHeight)
                    }
                }
            }

            /*AdoptFab(
                extended = scrollState.value == 0,
                modifier = Modifier.align(Alignment.BottomEnd)
            )*/
        }
    }
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

        ProfileProperty(stringResource(R.string.sex), puppy.sex)

        ProfileProperty(stringResource(R.string.age), puppy.age.toString())

        ProfileProperty(stringResource(R.string.personality), puppy.description)

        // Add a spacer that always shows part (320.dp) of the fields list regardless of the device,
        // in order to always leave some content at the top.
        Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
private fun Name(
    puppy: PersonEntity
) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Name(
            puppy = puppy,
            modifier = Modifier.baselineHeight(32.dp)
        )
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
fun ProfileProperty(label: String, value: String, isLink: Boolean = false) {
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
/*
@Composable
fun AdoptFab(extended: Boolean, modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = { *//* TODO *//* },
        modifier = modifier
            .padding(16.dp)
            .padding()
            .height(48.dp)
            .widthIn(min = 48.dp),
        backgroundColor = Purple500,
        contentColor = Color.White
    ) {
        AnimatingFabContent(
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Call,
                    contentDescription = stringResource(R.string.adopt_me)
                )
            },
            text = {
                Text(
                    text = stringResource(R.string.adopt_me),
                )
            },
            extended = extended

        )
    }
}*/

@Preview
@Composable
fun ProfilePreview() {
    val puppy = DataProvider.person
    ProfileScreen(person = puppy)
}
