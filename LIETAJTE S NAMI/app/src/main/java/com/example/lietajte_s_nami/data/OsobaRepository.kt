package com.example.lietajte_s_nami.data

import kotlinx.coroutines.flow.Flow

class OsobaRepository(private val osobaDao: OsobaDao) {

    val osobyStream: Flow<List<Osoba>> = osobaDao.getAllStream()

    suspend fun pridajOsobu(osoba: Osoba) {
        osobaDao.insert(osoba)
    }

    suspend fun nacitajVsetky(): List<Osoba> {
        return osobaDao.getAll()
    }
}
