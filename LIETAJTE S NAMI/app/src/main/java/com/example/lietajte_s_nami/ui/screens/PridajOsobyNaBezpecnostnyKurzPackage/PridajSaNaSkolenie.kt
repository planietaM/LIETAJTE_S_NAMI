package com.example.lietajte_s_nami.ui.screens.PridajOsobyNaBezpecnostnyKurzPackage

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.lietajte_s_nami.R
import com.example.lietajte_s_nami.data.Osoba
import com.example.lietajte_s_nami.data.OsobaDatabase
import com.example.lietajte_s_nami.ui.screens.BezpecnostnaKontrolaPackage.GreetingText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.activity.compose.BackHandler


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PridajSaNaSkolenie(navController: NavHostController) {
    val context = LocalContext.current
    val db = remember { OsobaDatabase.getDatabase(context) }
    val osobaDao = db.osobaDao()

    //aktualizujem ze v pamati sa nevratim nazad
    BackHandler {
        navController.navigate("home") {
            popUpTo("pridaj") { inclusive = true }
        }
    }

    var meno by remember { mutableStateOf("") }
    var priezvisko by remember { mutableStateOf("") }
    var telefon by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var osobaBolaPridana = false
    Scaffold(containerColor = Color(0xFF1BB2C7)) {
        val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(12.dp),

    ) {
        GreetingText(stringResource(id = R.string.PridajSaBOZPKurz), 40 , hrubePismo = true ,normalnyStylPisma = false )

        var problemPreMeno by remember { mutableStateOf("") }
        var problemPrePriezvisko by remember { mutableStateOf("") }
        var problemPreTelCislo by remember { mutableStateOf("") }
        var problemPreMail by remember { mutableStateOf("") }

        OutlinedTextField(
            value = meno,
            onValueChange = { meno = it },
            label = { Text(stringResource(R.string.label_meno), color = Color.Black) },
            modifier = Modifier.fillMaxWidth().background(Color.White)
        )
        if (problemPreMeno.isNotEmpty()) {
            Text(
                text = problemPreMeno,
                color = Color.Black,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        OutlinedTextField(
            value = priezvisko,
            onValueChange = { priezvisko = it },
            label = { Text(stringResource(R.string.label_priezvisko), color = Color.Black) },
            modifier = Modifier.fillMaxWidth().background(Color.White)
        )
        if (problemPrePriezvisko.isNotEmpty()) {
            Text(
                text = problemPrePriezvisko,
                color = Color.Black,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        OutlinedTextField(
            value = telefon,
            onValueChange = { telefon = it },
            label = { Text(stringResource(R.string.label_telefon), color = Color.Black) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.background(Color.White).fillMaxWidth()
        )
        if (problemPreTelCislo.isNotEmpty()) {
            Text(
                text = problemPreTelCislo,
                color = Color.Black,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(stringResource(R.string.label_email), color = Color.Black) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.background(Color.White).fillMaxWidth()
        )
        if (problemPreMail.isNotEmpty()) {
            Text(
                text = problemPreMail,
                color = Color.Black,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Button(
            onClick = {
                val menoValid = meno.all { it.isLetter() || it.isWhitespace() }
                val priezviskoValid = priezvisko.all { it.isLetter() || it.isWhitespace() }
                val emailValid = email.contains("@")
                val telefonValid = telefon.all { it.isDigit() || "+".contains(it) }

                var problem = false
                if (!menoValid) {
                    problemPreMeno = context.getString(R.string.error_meno)
                    problem = true
                } else {
                    problemPreMeno = ""
                }

                if (!priezviskoValid) {
                    problemPrePriezvisko = context.getString(R.string.error_priezvisko)
                    problem = true
                } else {
                    problemPrePriezvisko = ""
                }

                if (!emailValid) {
                    problemPreMail = context.getString(R.string.error_email)
                    problem = true
                } else {
                    problemPreMail = ""
                }

                if (!telefonValid) {
                    problemPreTelCislo = context.getString(R.string.error_telefon)
                    problem = true
                } else {
                    problemPreTelCislo = ""
                }

                if (!problem) {
                    val novaOsoba = Osoba(
                        meno = meno,
                        priezvisko = priezvisko,
                        telefon = telefon,
                        email = email
                    )
                    osobaBolaPridana = true
                    CoroutineScope(Dispatchers.IO).launch {
                        osobaDao.insert(novaOsoba)
                    }

                    meno = ""
                    priezvisko = ""
                    telefon = ""
                    email = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.ulozit))
        }

        if (osobaBolaPridana) {
            Text(
                text = stringResource(R.string.osoba_pridana),
                color = Color.Black,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        }


    }
}
