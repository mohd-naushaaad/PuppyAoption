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
package com.example.androiddevchallenge.model

import com.example.androiddevchallenge.R

data class PuppyModel(
    val id: Int = -1,
    var image: Int = 0,
    var name: String = "",
    val gender: String = "",
    val weight: Int = 0,
    val color: String = "",
    val age: Int = 0,
    val description: String = ""
)

fun getPuppyList(): List<PuppyModel> {
    return listOf(
        PuppyModel(
            1,
            R.drawable.puppy_1,
            "Cooper",
            "male",
            4,
            "white",
            1,
            "Cooper is cute puppy. Puppies are born with a fully functional sense of smell. They are unable to open their eyes. During their first two weeks, a puppy's senses all develop rapidly."
        ),
        PuppyModel(
            2,
            R.drawable.puppy_2,
            "Rocky",
            "male",
            7,
            "brown",
            3,
            "Rocky is cute puppy. Puppies are born with a fully functional sense of smell. They are unable to open their eyes. During their first two weeks, a puppy's senses all develop rapidly."
        ),
        PuppyModel(
            3,
            R.drawable.puppy_3,
            "Tucker",
            "male",
            5,
            "chocolate",
            3,
            "Tucker is cute puppy. Puppies are born with a fully functional sense of smell. They are unable to open their eyes. During their first two weeks, a puppy's senses all develop rapidly."
        ),
        PuppyModel(
            4,
            R.drawable.puppy_4,
            "Kai",
            "male",
            6,
            "black",
            2,
            "Kai is cute puppy. Puppies are born with a fully functional sense of smell. They are unable to open their eyes. During their first two weeks, a puppy's senses all develop rapidly."
        ),
        PuppyModel(
            5,
            R.drawable.puppy_5,
            "Maggie",
            "female",
            4,
            "brown",
            3,
            "Maggie is cute puppy. Puppies are born with a fully functional sense of smell. They are unable to open their eyes. During their first two weeks, a puppy's senses all develop rapidly."
        ),
        PuppyModel(
            6,
            R.drawable.puppy_6,
            "Max",
            "male",
            5,
            "chocolate",
            1,
            "Max is cute puppy. Puppies are born with a fully functional sense of smell. They are unable to open their eyes. During their first two weeks, a puppy's senses all develop rapidly."
        ),
        PuppyModel(
            7,
            R.drawable.puppy_7,
            "Bailey",
            "female",
            6,
            "white",
            2,
            "Bailey is cute puppy. Puppies are born with a fully functional sense of smell. They are unable to open their eyes. During their first two weeks, a puppy's senses all develop rapidly."
        ),
        PuppyModel(
            8,
            R.drawable.puppy_8,
            "Sophie",
            "female",
            9,
            "brown",
            3,
            "Sophie is cute puppy. Puppies are born with a fully functional sense of smell. They are unable to open their eyes. During their first two weeks, a puppy's senses all develop rapidly."
        ),
        PuppyModel(
            9,
            R.drawable.puppy_9,
            "Toby",
            "male",
            5,
            "yellow",
            2,
            "Toby is cute puppy. Puppies are born with a fully functional sense of smell. They are unable to open their eyes. During their first two weeks, a puppy's senses all develop rapidly."
        ),
        PuppyModel(
            10,
            R.drawable.puppy_10,
            "Chloe",
            "female",
            8,
            "brown",
            3,
            "Chloe is cute puppy. Puppies are born with a fully functional sense of smell. They are unable to open their eyes. During their first two weeks, a puppy's senses all develop rapidly."
        )
    )
}

fun getPuppyFromId(id: Int): PuppyModel {
    return getPuppyList().find { puppy -> id == puppy.id } ?: PuppyModel()
}
