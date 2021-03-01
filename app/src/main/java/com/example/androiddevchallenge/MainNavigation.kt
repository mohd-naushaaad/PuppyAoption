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
package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.screenviews.PuppyDetails
import com.example.androiddevchallenge.ui.screenviews.PuppyList
import com.example.androiddevchallenge.ui.screenviews.ScreenViews

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenViews.PuppyList.route) {

        composable(route = ScreenViews.PuppyList.route) {
            PuppyList(
                onItemClick = { puppyId ->
                    navController.navigate("${ScreenViews.PuppyDetails.route}/$puppyId")
                }
            )
        }

        composable(
            route = "${ScreenViews.PuppyDetails.route}/{puppyId}",
            arguments = listOf(navArgument("puppyId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.getInt("puppyId")?.let { puppyId ->
                PuppyDetails(
                    puppyId = puppyId,
                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}
