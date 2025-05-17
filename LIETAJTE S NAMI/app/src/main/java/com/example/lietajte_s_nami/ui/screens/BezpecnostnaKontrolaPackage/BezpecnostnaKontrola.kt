package com.example.lietajte_s_nami.ui.screens.BezpecnostnaKontrolaPackage


import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lietajte_s_nami.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.lietajte_s_nami.data.UzNahraneData.BezpecnostnaKontrolaData


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BezpecnostnaKontrola(navController: NavController) {
    val prvky = BezpecnostnaKontrolaData.BezpecnostnaKontrolaData
    var currentIndex by remember { mutableStateOf(0) }
    var checkClicked by remember { mutableStateOf(false) }

    val currentItem = prvky[currentIndex]
    val context = LocalContext.current
    val imageId = remember(currentItem.id) {
        val resourceName = "bzpkontrola${currentItem.id}"
        context.resources.getIdentifier(resourceName, "drawable", context.packageName)
    }
    Scaffold(containerColor = Color(0xFF1BB2C7)) {
        val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        GreetingText(
            stringResource(id = R.string.BezpecnostnaKontrola),
            40,
            bezPozadia = true,
            normalnyStylPisma = false,
            hrubePismo = true,
            rgbTextu = 0xFFFFFFFF
        )

        GreetingText(currentItem.nadpisBezpecnostnehoOkna, 20, bezPozadia = true, hrubePismo = true)

        if (imageId != 0) {
            GreetingImage(painterResource(id = imageId))
        }

        GreetingText(currentItem.popisBezpecnostnehoOkna, 16)

        Spacer(modifier = Modifier.height(5.dp))

        // Checkbox „Rozumiem“
        ConfirmationCheckbox(
            checked = checkClicked,
            onCheckedChange = { checkClicked = it }
        )

    Spacer(modifier = Modifier.height(5.dp))
        CustomButton(
            text = stringResource(id = R.string.SpatBozp),
            onClick = {
                if (currentIndex <= 0) {
                    navController.navigate("home")
                } else {
                    currentIndex--
                    checkClicked = false
                }
            }
        )

        CustomButton(
            text = if (currentIndex < prvky.size - 1) {
                stringResource(id = R.string.DalsiaOtazkaBOZP)
            } else {
                stringResource(id = R.string.Dokonci)
            },
            enabled = checkClicked,
            onClick = {
                if (currentIndex < prvky.size - 1) {
                    currentIndex++
                    checkClicked = false
                } else {
                    navController.navigate("pripravenyNaOdlet")
                }
            }
        )

    }
    }
}


@Composable
fun GreetingImage(image: Painter) {
      painterResource(R.drawable.stranik_uvod)
    Image(
        painter = image,
        contentDescription = null,

        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .padding(bottom = 5.dp)
            .padding(top = 5.dp),

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
        modifier = modifier
            .fillMaxWidth()
            .
            //padding((velkost/3).dp).
            background(pozadie)
            .padding(10.dp),
        fontSize = velkost.sp,
        lineHeight = velkost.sp,
        textAlign = TextAlign.Center,
        //softWrap = true,
        color =  Color(rgbTextu),
        fontFamily = stylPisma,
        fontWeight = fontWeight,

        )
}

@Composable
fun CustomButton(text: String, onClick: () -> Unit, enabled: Boolean = true,modifier: Modifier = Modifier) {
    Button(

        onClick = onClick,
        enabled = enabled,
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

@Composable
fun ConfirmationCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    text: String = stringResource(id = R.string.RozumiemBoyp),
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(10.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                uncheckedColor = Color.Gray,
                checkmarkColor = Color.White
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}