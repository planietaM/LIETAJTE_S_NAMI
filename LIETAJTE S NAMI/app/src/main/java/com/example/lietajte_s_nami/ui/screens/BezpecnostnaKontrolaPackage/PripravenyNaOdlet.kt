package com.example.lietajte_s_nami.ui.screens.BezpecnostnaKontrolaPackage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lietajte_s_nami.R


@Composable
fun PripravenyNaOdlet(navController: NavHostController) {
    Scaffold(containerColor = Color(0xFF1BB2C7)) { innerPadding ->
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding).verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            GreetingText(stringResource(id = R.string.UspecnaKontrola), 40 , hrubePismo = true ,normalnyStylPisma = false )
            GreetingImage()
            CustomButton(stringResource(id = R.string.zopakujBezpKontorlu), onClick = {navController.navigate("security")})
            CustomButton(stringResource(id = R.string.pridajSaNaKurz), onClick = { navController.navigate("pridajSaNaSkolenie") })
            CustomButton(stringResource(id = R.string.BOZPUvod), onClick = { navController.navigate("home") })
        }


    }
}

@Composable
fun GreetingImage() {
    val image = painterResource(R.drawable.bzpkontrolafinish)
    Image(
        painter = image,
        contentDescription = null,
        //ked mam citacku
        //contentScale = ContentScale.FillBounds,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .padding(bottom = 5.dp)
            .padding(top = 5.dp)

    )
}

@Composable
fun CustomButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(

        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(10.dp),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(Color.White),
        border = BorderStroke(2.dp, Color.Black)

    ) {

        Text(text = text, fontSize = 18.sp, color = Color.Black , fontWeight = FontWeight.Bold )
    }
}

