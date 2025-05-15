package com.example.lietajte_s_nami.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.lietajte_s_nami.screens.BezpecnostnaKontrolaPackage.BezpecnostnaKontrola
import com.example.lietajte_s_nami.screens.DomovskaObrazovkaPackage.DomovskaObrazovka
import com.example.lietajte_s_nami.screens.DostupneKurzyPackage.DostupneKurzy
import com.example.lietajte_s_nami.screens.DostupneKurzyPackage.DetailKurzuScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigator(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { DomovskaObrazovka(navController) }
        composable("security") { BezpecnostnaKontrola(navController) }
        composable("courses") { DostupneKurzy(navController) }


        composable("kurzDetail/{kurzId}") { backStackEntry ->
            val kurzId = backStackEntry.arguments?.getString("kurzId")?.toIntOrNull() ?: -1
            DetailKurzuScreen(kurzId = kurzId)
        }
    }
}