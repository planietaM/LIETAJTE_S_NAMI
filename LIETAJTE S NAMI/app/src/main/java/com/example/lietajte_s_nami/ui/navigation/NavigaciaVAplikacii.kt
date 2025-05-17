package com.example.lietajte_s_nami.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.lietajte_s_nami.ui.screens.BezpecnostnaKontrolaPackage.BezpecnostnaKontrola
import com.example.lietajte_s_nami.ui.screens.DomovskaObrazovkaPackage.DomovskaObrazovka
import com.example.lietajte_s_nami.ui.screens.DostupneKurzyPackage.DostupneKurzy
import com.example.lietajte_s_nami.ui.screens.DostupneKurzyPackage.DetailKurzuScreen
import com.example.lietajte_s_nami.ui.screens.BezpecnostnaKontrolaPackage.PripravenyNaOdlet
import com.example.lietajte_s_nami.ui.screens.PridajOsobyNaBezpecnostnyKurzPackage.PridajSaNaSkolenie
import com.example.lietajte_s_nami.ui.screens.VypisZaujemcovOBezpecnostnyKurzPackage.VypisOsobScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigator(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { DomovskaObrazovka(navController) }
        composable("security") { BezpecnostnaKontrola(navController) }
        composable("courses") { DostupneKurzy(navController) }
        composable("pripravenyNaOdlet") { PripravenyNaOdlet(navController) }
        composable("pridajSaNaSkolenie") { PridajSaNaSkolenie(navController) }
        composable("vypis_osob") { VypisOsobScreen(navController) }

        composable("kurzDetail/{kurzId}") { backStackEntry ->
            val kurzId = backStackEntry.arguments?.getString("kurzId")?.toIntOrNull() ?: -1
            DetailKurzuScreen(kurzId = kurzId)
        }


    }
}