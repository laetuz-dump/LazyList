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

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.neotica.lazylist.data.DataProvider
import com.neotica.lazylist.data.model.PersonEntity

@Composable
fun BarkHomeContent(navigateToProfile: (PersonEntity) -> Unit) {
    val persons = remember { DataProvider.personList }
    ConstraintLayout() {
        val (list, topBar) = createRefs()
        Box(Modifier.constrainAs(list){
            top.linkTo(topBar.bottom)
        }) {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 1.dp),
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxHeight(1f)
            ) {
                items(
                    items = persons,
                    itemContent = {
                        PersonListItemView(person = it, navigateToProfile)
                    }
                )
            }
            /*Box(
                Modifier
                    .fillMaxSize()
                    .height(685.dp)
                    .align(Alignment.TopCenter)
                    .fillMaxHeight(4f)
            )
            {
                Topbar1()
            }*/
        }
        Box(Modifier.constrainAs(topBar){

        }) {
            Topbar1()
        }


    }
    /*Box(Modifier.fillMaxSize()) {
        BoxWithConstraints() {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 1.dp),
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxHeight(1f)
            ) {
                items(
                    items = persons,
                    itemContent = {
                        PersonListItemView(person = it, navigateToProfile)
                    }
                )
            }
            Box(
                Modifier
                    .fillMaxSize()
                    .height(685.dp)
                    .align(Alignment.TopCenter)
                    .fillMaxHeight(4f)
            )
            {
                Topbar1()
            }
        }
        }
        //  Topbar1()
        Box{


    }*/
}