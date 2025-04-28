package com.example.lietajte_s_nami.data

import java.time.LocalDate

data class Kurz(
    val id: Int,
    val nazovKurzu: String,
    val cenaKurzu: Double,
    val miestoKonaniaPSC: String,
    val miestoKonania: String,
    val datumZaciatok: LocalDate,
    val datumKoniec: LocalDate,
    val typKurzu: String,
    val mail: String,
    val telefon: String,
    val popisKurzu1: String,
    val popisKurzu2: String,
    val popisKurzu3: String,
)