package com.neotica.lazylist

import android.app.Activity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
fun ProfileScreen(person: PersonEntity) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Column {
            TopBarProfile()
            BoxWithConstraints(modifier = Modifier.weight(1f)) {
                Box {
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
            }
        }
    }
}

@Composable
fun TopBarProfile() {
    Column {
        TopAppBar(
            title = {
                Text(text = "Profile")
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

@Composable
private fun ProfileHeader(
    scrollState: ScrollState,
    entity: PersonEntity,
    containerHeight: Dp
) {
    val offset = (scrollState.value / 2)
    val offsetDp = with(LocalDensity.current) { offset.toDp() }

    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth()
            .padding(top = offsetDp),
        painter = painterResource(id = entity.personImageId),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
private fun ProfileContent(entity: PersonEntity, containerHeight: Dp) {
    Column {
        Spacer(modifier = Modifier.height(8.dp))

        Name(entity)

        ProfileProperty(stringResource(R.string.sex), entity.sex)

        ProfileProperty(stringResource(R.string.age), entity.age.toString())

        ProfileProperty(stringResource(R.string.personality), entity.description)

        Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
private fun Name(
    entity: PersonEntity
) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Name(
            entity = entity,
            modifier = Modifier.baselineHeight(32.dp)
        )
    }
}

@Composable
private fun Name(entity: PersonEntity, modifier: Modifier = Modifier) {
    Text(
        text = entity.title,
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

@Preview
@Composable
fun ProfilePreview() {
    val artist = DataProvider.person
    ProfileScreen(person = artist)
}
