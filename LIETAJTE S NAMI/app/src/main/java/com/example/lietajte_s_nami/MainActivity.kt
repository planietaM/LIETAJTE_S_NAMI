package com.example.lietajte_s_nami

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lietajte_s_nami.ui.theme.LIETAJTE_S_NAMITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            LIETAJTE_S_NAMITheme {
                Scaffold(modifier = Modifier.fillMaxSize(),containerColor = Color(0xFF1BB2C7)) { innerPadding ->
                    Column(
                        modifier = Modifier.fillMaxSize().padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        GreetingText("Lietajte s nami", 40,bezPozadia = false , normalnyStylPisma = false, hrubePismo = true, rgbTextu = 0xFF1BB2C7)
                        GreetingText("ÚVOD ", 40 , hrubePismo = true)
                        CustomButton(text = "KURZY", onClick = {})
                        CustomButton(text = "BEZPEČNOSTNÁ KONTROLA", onClick = {})
                        GreetingImage()
                        val citat = "\"Lietajte bezpečnejšie lietajte s nami \""
                        GreetingText(citat, 37, hrubePismo = true, rgbTextu = 0xFFFFFFFF)
                        val text = "Keď sa písal rok 2022 a ja som sa prihlásil na môj paraglidingový kurz, tak bolo ťažké nájsť tie správne informácie a vďaka tejto aplikácii ich nájdete na jednom mieste."
                        GreetingText(text, 30 , )
                    }
                }



            }
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
    LIETAJTE_S_NAMITheme {
        Scaffold(modifier = Modifier.fillMaxSize(),containerColor = Color(0xFF1BB2C7)) { innerPadding ->
            Column(
                modifier = Modifier.fillMaxSize().padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GreetingText("Lietajte s nami ", 40,bezPozadia = false)
                GreetingImage()
                CustomButton(text = "Moje tlačidlo", onClick = {})
                CustomButton(text = "Bezpecnost", onClick = {})
            }
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