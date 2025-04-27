package com.example.lietajte_s_nami.screens.BezpecnostnaKontrolaPackage


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lietajte_s_nami.R

@Composable
fun BezpecnostnaKontrola(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bezpečnostná kontrola", Modifier.padding(bottom = 16.dp))
        Image(
            painter = painterResource(id = R.drawable.stranik_uvod), // tvoje pozadie, alebo spravíš nové obrázky
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clickable {

                }
        )
    }
}