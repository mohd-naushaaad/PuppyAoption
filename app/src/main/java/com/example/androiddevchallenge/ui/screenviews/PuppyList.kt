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
package com.example.androiddevchallenge.ui.screenviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.PuppyModel
import com.example.androiddevchallenge.model.getPuppyList
import com.example.androiddevchallenge.ui.customviews.ListTopBar
import com.example.androiddevchallenge.ui.theme.lightGreen
import com.example.androiddevchallenge.ui.theme.white

@Composable
fun PuppyList(onItemClick: (Int) -> Unit) {

    val puppyList = getPuppyList()

    Scaffold(
        topBar = {
            ListTopBar()
        }
    ) {
        LazyColumn {
            items(puppyList) { puppy ->
                PuppyItemList(puppy = puppy, onItemClick = onItemClick)
            }
        }
    }
}

@Composable
fun PuppyItemList(
    puppy: PuppyModel,
    onItemClick: (Int) -> Unit
) {

    Card(
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onItemClick(puppy.id) }
    ) {
        Column {
            Image(
                painter = painterResource(id = puppy.image),
                contentDescription = "Puppy Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.size(4.dp))

            AddPuppyDetail(puppyModel = puppy)
        }
    }
}

@Composable
fun AddPuppyDetail(
    puppyModel: PuppyModel
) {
    Row(modifier = Modifier.padding(16.dp)) {

        Text(
            text = puppyModel.name,
            style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Medium)
        )
        Spacer(modifier = Modifier.size(8.dp))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(color = lightGreen)
        ) {
            Text(
                text = puppyModel.gender,
                style = MaterialTheme.typography.body2,
                color = white,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp)
            )
        }
        Spacer(modifier = Modifier.size(8.dp))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(color = lightGreen)
        ) {
            Text(
                text = "${puppyModel.age} years",
                style = MaterialTheme.typography.body2,
                color = white,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp)
            )
        }
        Spacer(modifier = Modifier.size(8.dp))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(color = lightGreen)
        ) {
            Text(
                text = "${puppyModel.weight} kg",
                style = MaterialTheme.typography.body2,
                color = white,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp)
            )
        }
    }
}
