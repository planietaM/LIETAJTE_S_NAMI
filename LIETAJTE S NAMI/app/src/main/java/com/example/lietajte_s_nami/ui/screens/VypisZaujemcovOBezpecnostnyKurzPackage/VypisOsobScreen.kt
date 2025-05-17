package com.example.lietajte_s_nami.ui.screens.VypisZaujemcovOBezpecnostnyKurzPackage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.lietajte_s_nami.R
import com.example.lietajte_s_nami.screens.VypisZaujemcovOBezpecnostnyKurzPackage.VypisOsobViewModel
import com.example.lietajte_s_nami.screens.VypisZaujemcovOBezpecnostnyKurzPackage.VypisOsobViewModelFactory
import com.example.lietajte_s_nami.LietajteSNamiApplication

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VypisOsobScreen(navController: NavHostController) {
    val context = LocalContext.current
    val app = context.applicationContext as LietajteSNamiApplication

    val viewModel: VypisOsobViewModel = viewModel(
        factory = VypisOsobViewModelFactory(app.osobaRepository)
    )

    val osoby by viewModel.osoby.collectAsState()

    Scaffold(
        containerColor = Color(0xFF1BB2C7) // celé pozadie
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Použitie GreetingText s modrým pozadím a čiernym textom
            GreetingText(
                stringResource(id = R.string.BezpecnostnaKontrola),
                40,
                bezPozadia = true,
                normalnyStylPisma = false,
                hrubePismo = true,
                rgbTextu = 0xFFFFFFFF
            )

            // Zoznam osôb
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                items(osoby) { osoba ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0)),
                        elevation = CardDefaults.cardElevation()
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "${osoba.meno} ${osoba.priezvisko}",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.Black
                            )
                            Text(
                                text = osoba.telefon,
                                color = Color.Black
                            )
                            Text(
                                text = osoba.email,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}



@Composable
fun GreetingText(name: String, velkost: Int, bezPozadia: Boolean = true ,rgbTextu: Long = 0xFF000000,hrubePismo: Boolean = false,normalnyStylPisma: Boolean = true ,modifier: Modifier = Modifier ,rgbPozadia: Long = 0xFF000000) {
    val pozadie: Color
    if(bezPozadia) {
        pozadie = Color.Transparent
    } else {
        pozadie = Color(rgbPozadia)
    }
    val stylPisma: FontFamily
    if(normalnyStylPisma) {
        stylPisma = FontFamily.Default

    } else {
        stylPisma = FontFamily(Font(R.font.inkfree))
    }
    val fontWeight: FontWeight
    if(hrubePismo) {
        fontWeight = FontWeight.Bold
    } else {
        fontWeight = FontWeight.Normal
    }
    Text(
        text = name,
        modifier = modifier.
        fillMaxWidth().
        background(pozadie).
        padding(10.dp),
        fontSize = velkost.sp,
        lineHeight = velkost.sp,
        textAlign = TextAlign.Center,
        softWrap = true,
        color =  Color(rgbTextu),
        fontFamily = stylPisma,
        fontWeight = fontWeight,

        )
}