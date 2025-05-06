package com.example.lietajte_s_nami.screens.DostupneKurzyPackage

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.lietajte_s_nami.R
import com.example.lietajte_s_nami.data.DataSource
import com.example.lietajte_s_nami.screens.DomovskaObrazovkaPackage.GreetingText
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.EuroSymbol
import androidx.compose.material.icons.filled.Event
import android.content.Context
import android.content.Intent
import android.location.Geocoder

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import com.google.android.gms.maps.CameraUpdateFactory

@RequiresApi(Build.VERSION_CODES.O)
@Composable

fun DetailKurzuScreen(kurzId: Int) {
    val kurz = DataSource.kurzy.firstOrNull { it.id == kurzId } ?: return
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1) Nadpis
        GreetingText(
            name = kurz.nazovKurzu,
            velkost = 40,
            bezPozadia = true,
            normalnyStylPisma = false,
            hrubePismo = true,
            rgbTextu = 0xFF1BB2C7,
        )

        // 2) Popis kurzu – menší, tmavý text, biele pozadie
        GreetingText(
            name = kurz.popisKurzu1,
            velkost = 20,
            bezPozadia = true,
            normalnyStylPisma = true,
            hrubePismo = false,
        )

        Spacer(modifier = Modifier.height(5.dp))

        GreetingIkonaAndText("Miesto kurzu: ${kurz.miestoKonania}" ,20, ikonka = Icons.Default.LocationOn)
        GreetingIkonaAndText( "Začiatok: ${kurz.datumZaciatok}",20, ikonka = Icons.Default.Event)
        GreetingIkonaAndText( "Koniec: ${kurz.datumKoniec}",20, ikonka = Icons.Default.Event)
        GreetingIkonaAndText( "Cena: ${kurz.cenaKurzu}",20, ikonka = Icons.Default.EuroSymbol)

        CourseScreen(kurz.miestoKonaniaPSC)

        GreetingIkonaAndText( "Kontakt",25,)
        CustomButtonMail(kurz.mail , 20, ikonka = Icons.Default.Email, idKurzu = kurz.id)
        CustomButtonTelephone(kurz.telefon , 20,  ikonka = Icons.Default.Phone)

        GreetingText(
            name = kurz.popisKurzu2,
            velkost = 20,
            bezPozadia = true,
            normalnyStylPisma = true,
            hrubePismo = false,
        )
        Spacer(modifier = Modifier.height(5.dp))
        GreetingText(
            name = kurz.popisKurzu3,
            velkost = 20,
            bezPozadia = true,
            normalnyStylPisma = true,
            hrubePismo = false,
        )
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
            //padding((velkost/3).dp).
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


@Composable
fun GreetingIkonaAndText(
    name: String,
    velkost: Int,
    modifier: Modifier = Modifier,
    ikonka: ImageVector? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        ikonka?.let {
            Icon(
                imageVector        = it,
                contentDescription = null,
                tint               = Color(0xFF1BB2C7),
                modifier           = Modifier.size((velkost * 6 / 4).dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text      = name,
            fontSize  = velkost.sp,
            modifier  = Modifier,
                //.weight(1f)
                //.padding(10.dp)
            lineHeight = velkost.sp,
            textAlign  = TextAlign.Start,
            softWrap   = true,
            color      = Color(0xFF333333)
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CustomButtonMail(text: String,velkost: Int, modifier: Modifier = Modifier ,  ikonka : ImageVector?  = null, idKurzu : Int) {
    val context = LocalContext.current
    Button(onClick = {
        shareOrder(context , idKurzu)
        },
        modifier = modifier.
        fillMaxWidth().
        height(80.dp).
        padding(10.dp),
        shape = RectangleShape,
        border = BorderStroke(3.dp, Color.Black),
        colors = ButtonDefaults.buttonColors(Color.White)

    ) {
        GreetingIkonaAndText(text, velkost, ikonka = ikonka)
    }
}
@Composable
fun CustomButtonTelephone(text: String,velkost: Int, modifier: Modifier = Modifier ,  ikonka : ImageVector?  = null ) {
    val context = LocalContext.current
    Button(onClick = {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = android.net.Uri.parse("tel:$text")
        }
        context.startActivity(intent)
        },
        modifier = modifier.
        fillMaxWidth().
        height(80.dp).
        padding(10.dp),
        shape = RectangleShape,
        border = BorderStroke(3.dp, Color.Black),
        colors = ButtonDefaults.buttonColors(Color.White)
    ) {
        GreetingIkonaAndText(text, velkost, ikonka = ikonka)
    }
}



@Composable
fun CourseScreen(postalCode: String) {
    val context = LocalContext.current
    var coordinates by remember { mutableStateOf(LatLng(48.1486, 17.1077)) } // ✅ MutableState, nie len konstanta
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(coordinates, 12f)
    }

    LaunchedEffect(postalCode) {
        val fullPostalQuery = "$postalCode, Slovakia"
        val newCoordinates = getCoordinatesFromPostalCode(context, fullPostalQuery)
        if (newCoordinates != null) {
            coordinates = newCoordinates // ✅ aktualizujeme coordinates
            val cameraUpdate = CameraUpdateFactory.newLatLngZoom(newCoordinates, 14f)
            cameraPositionState.animate(cameraUpdate)
        }
    }

    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        GoogleMap(
            modifier = Modifier
                .fillMaxWidth()
                .height((screenWidthDp * 2 / 3).dp),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = MarkerState(position = coordinates),
                title = "Miesto kurzu",
                snippet = postalCode
            )
        }
    }
}


suspend fun getCoordinatesFromPostalCode(context: Context, postalCode: String): LatLng? {
    return withContext(Dispatchers.IO) {
        try {
            val geocoder = Geocoder(context, Locale.getDefault())
            val addresses = geocoder.getFromLocationName(postalCode, 1)
            if (addresses?.isNotEmpty() == true) {
                LatLng(addresses[0].latitude, addresses[0].longitude)
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}


//podobny system pri cupcakoch zmenen len type inac same
@RequiresApi(Build.VERSION_CODES.O)
fun shareOrder(context: Context, kurzId: Int) {
    val kurz = DataSource.kurzy.firstOrNull { it.id == kurzId } ?: return

    val intent = Intent(Intent.ACTION_SENDTO).apply {
        type = "message/rfc822"
        putExtra(Intent.EXTRA_EMAIL, arrayOf(kurz.mail))
        putExtra(Intent.EXTRA_SUBJECT, "Záujem o kurz: ${kurz.typKurzu}")
        putExtra(Intent.EXTRA_TEXT, "Dotycny/na ma zaujem o kuz ktory sa uskutocni v datumoch od ${kurz.datumZaciatok} do ${kurz.datumKoniec} . Na prihlasenie na kurz prosim vyplnte vase Meno , Prizvisko pre viac info sa viete dovolat na tel. cisle ${kurz.telefon} .")
    }

    context.startActivity(
        Intent.createChooser(
            intent,
            "Zdieľať kurz cez..."
        )
    )
}