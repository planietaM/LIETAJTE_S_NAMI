package com.example.lietajte_s_nami.data

import java.time.LocalDate

data class Kurz(
    val nazovKurzu: String,
    val cenaKurzu: Double,
    val miestoKonaniaPSC: String,
    val miestoKonania: String,
    val datumZaciatok: LocalDate,
    val datumKoniec: LocalDate,
    val typKurzu: String
)