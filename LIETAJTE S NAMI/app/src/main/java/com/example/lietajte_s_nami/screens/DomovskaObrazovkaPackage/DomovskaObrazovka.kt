package com.example.lietajte_s_nami.screens.DomovskaObrazovkaPackage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lietajte_s_nami.R

@Composable
fun DomovskaObrazovka(navController: NavController) {
    Scaffold(containerColor = Color(0xFF1BB2C7)) { innerPadding ->
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding).verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            GreetingText(stringResource(id = R.string.nadpis_domovska_obrazovka), 40,bezPozadia = false , normalnyStylPisma = false, hrubePismo = true, rgbTextu = 0xFF1BB2C7)
            GreetingText(stringResource(id = R.string.podnadpis_domovska_obrazovka), 40 , hrubePismo = true)
            CustomButton(text = stringResource(id = R.string.tlacidloKurzy), onClick = {navController.navigate("courses")})
            CustomButton(text = stringResource(id = R.string.tlacidloBezpecnostnaKontrola), onClick = {navController.navigate("security")})
            GreetingImage()
            GreetingText(stringResource(id = R.string.slogan_domovska_obrazovka), 37, hrubePismo = true, rgbTextu = 0xFFFFFFFF)
            GreetingText(stringResource(id = R.string.text_domovska_obrazovka), 30 , )
        }
    }
}

@Composable
fun GreetingImage() {
    val image  =  painterResource(R.drawable.stranik_uvod)
    Image(
        painter = image,
        contentDescription = null,
        //ked mam citacku
        //contentScale = ContentScale.FillBounds,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth().
        padding(bottom = 5.dp).padding(top = 5.dp)

    )
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Scaffold(containerColor = Color(0xFF1BB2C7)) { innerPadding ->
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding).verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            GreetingText(stringResource(id = R.string.nadpis_domovska_obrazovka), 40,bezPozadia = false , normalnyStylPisma = false, hrubePismo = true, rgbTextu = 0xFF1BB2C7)
            GreetingText(stringResource(id = R.string.podnadpis_domovska_obrazovka), 40 , hrubePismo = true)
            CustomButton(text = stringResource(id = R.string.tlacidloKurzy), onClick = {})
            CustomButton(text = stringResource(id = R.string.tlacidloBezpecnostnaKontrola), onClick = {})
            GreetingImage()
            GreetingText(stringResource(id = R.string.slogan_domovska_obrazovka), 37, hrubePismo = true, rgbTextu = 0xFFFFFFFF)
            GreetingText(stringResource(id = R.string.text_domovska_obrazovka), 30 , )
        }
    }
}

@Composable
fun CustomButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = onClick,
        modifier = modifier.
        fillMaxWidth().
        height(80.dp).
        padding(10.dp),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(Color.White)

    ) {

        Text(text = text, fontSize = 18.sp, color = Color.Black , fontWeight = FontWeight.Bold )
    }
}