package com.example.lietajte_s_nami.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


import com.example.lietajte_s_nami.screens.DomovskaObrazovkaPackage.DomovskaObrazovka


@Composable
fun AppNavigator(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { DomovskaObrazovka(navController) }

    }
}