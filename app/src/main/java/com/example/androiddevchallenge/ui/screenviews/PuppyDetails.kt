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
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.getPuppyFromId
import com.example.androiddevchallenge.ui.customviews.DetailTopBar
import com.example.androiddevchallenge.ui.theme.green
import com.example.androiddevchallenge.ui.theme.lightGreen
import com.example.androiddevchallenge.ui.theme.white

@Composable
fun PuppyDetails(
    puppyId: Int,
    onNavigateBack: () -> Unit
) {

    val puppyModel = getPuppyFromId(id = puppyId)

    Scaffold(
        topBar = { DetailTopBar(onNavigateBack = onNavigateBack) }
    ) {
        LazyColumn {

            item {
                Image(
                    painter = painterResource(id = puppyModel.image),
                    contentDescription = "Puppy Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                )

                Spacer(modifier = Modifier.size(8.dp))
            }

            item { Name(puppyModel.name) }

            item {
                Details(
                    puppyModel.gender,
                    puppyModel.age,
                    puppyModel.weight,
                    puppyModel.color
                )
            }

            item { About(puppyModel.name, puppyModel.description) }
        }
    }
}

@Composable
fun Name(name: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Column {
            Text(text = name, style = MaterialTheme.typography.h6, color = green)
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(24))
                .background(color = lightGreen)
                .clickable {}
        ) {
            Text(
                text = "Adopt this Puppy",
                style = MaterialTheme.typography.button,
                color = white,
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}

@Composable
fun Details(gender: String, age: Int, weight: Int, color: String) {
    Row {
        DetailItem(title = "GENDER", subtitle = gender, color = lightGreen)
        DetailItem(title = "AGE", subtitle = "$age years", color = lightGreen)
        DetailItem(title = "WEIGHT", subtitle = "$weight kg", color = lightGreen)
        DetailItem(title = "COLOR", subtitle = color, color = lightGreen)
    }
}

@Composable
fun About(name: String, description: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "About $name", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = description)
    }
}

@Composable
fun DetailItem(title: String, subtitle: String, color: Color) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(20.dp))
            .requiredSize(88.dp)
            .background(color = color)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.Bold)
            Text(text = title, style = style, color = white)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = subtitle, style = style, color = white)
        }
    }
}
