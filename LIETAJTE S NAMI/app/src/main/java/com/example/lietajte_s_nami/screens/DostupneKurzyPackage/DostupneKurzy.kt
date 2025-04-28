package com.example.lietajte_s_nami.screens.DostupneKurzyPackage

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lietajte_s_nami.R
import com.example.lietajte_s_nami.data.DataSource
import com.example.lietajte_s_nami.data.Kurz


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DostupneKurzy(navController: NavController) {
    val kurzy = DataSource.kurzy

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        GreetingText(
            stringResource(id = R.string.DostupneKurzy),
            40,
            bezPozadia = true,
            normalnyStylPisma = false,
            hrubePismo = true,
            rgbTextu = 0xFF1BB2C7
        )


        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(kurzy) { kurz ->

                KurzCard(
                    kurz = kurz,
                    onClick = { navController.navigate("kurzDetail/${kurz.id}") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}


//kod som skopiroval a prerobil s webu : https://www.boltuix.com/2021/12/card_25.html
@Composable
fun KurzCard(kurz: Kurz, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1BB2C7)),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = kurz.nazovKurzu,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.fillMaxWidth()
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Typ: ${kurz.typKurzu}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "${kurz.cenaKurzu} €",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(
                onClick = { onClick() },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Viac informácií",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
fun GreetingText(name: String, velkost: Int, bezPozadia: Boolean = true ,rgbTextu: Long = 0xFF000000,hrubePismo: Boolean = false,normalnyStylPisma: Boolean = true ,modifier: Modifier = Modifier ) {
    val pozadie: Color
    if(bezPozadia) {
        pozadie = Color.Transparent
    } else {
        pozadie = Color.White
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
            //padding((velkost/3).dp).
        background(pozadie).
        padding(10.dp),
        fontSize = velkost.sp,
        lineHeight = velkost.sp,
        textAlign = TextAlign.Center,
        //softWrap = true,
        color =  Color(rgbTextu),
        fontFamily = stylPisma,
        fontWeight = fontWeight,

        )
}


