package com.example.lietajte_s_nami.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "osoby")
data class Osoba(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val meno: String,
    val priezvisko: String,
    val telefon: String,
    val email: String
)
