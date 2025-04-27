package com.example.lietajte_s_nami.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

object DataSource {

    @RequiresApi(Build.VERSION_CODES.O)
    val kurzy = listOf(
        Kurz(
            id = 1,
            nazovKurzu = "Základný kurz paraglidingu – Liptovský Mikuláš",
            cenaKurzu = 450.0,
            miestoKonaniaPSC = "031 01",
            miestoKonania = "Liptovský Mikuláš",
            datumZaciatok = LocalDate.of(2025, 5, 10),
            datumKoniec = LocalDate.of(2025, 5, 15),
            typKurzu = "Základný kurz",
            mail = "sejkfslkfgnl@gmail.com",
            telefon = "0950338316",
            popisKurzu = "popiss Kurzu"
        ),
        Kurz(
            id = 2,
            nazovKurzu = "Pokročilý paragliding – Donovaly",
            cenaKurzu = 500.0,
            miestoKonaniaPSC = "976 39",
            miestoKonania = "Donovaly",
            datumZaciatok = LocalDate.of(2025, 6, 5),
            datumKoniec = LocalDate.of(2025, 6, 10),
            typKurzu = "Pokročilý kurz",
            mail = "sejkfslkfgnl@gmail.com",
            telefon = "0950338316",
            popisKurzu = "popiss Kurzu"
        ),
        Kurz(
            id = 3,
            nazovKurzu = "Termicky kurz paraglidingu – Straník (Žilina)",
            cenaKurzu = 89.99,
            miestoKonaniaPSC = "010 01",
            miestoKonania = "Žilina – Straník",
            datumZaciatok = LocalDate.of(2025, 5, 1),
            datumKoniec = LocalDate.of(2025, 9, 30),
            typKurzu = "Termicky kurz",
            mail = "sejkfslkfgnl@gmail.com",
            telefon = "0950338316",
            popisKurzu = "popiss Kurzu"
        )

    )
}