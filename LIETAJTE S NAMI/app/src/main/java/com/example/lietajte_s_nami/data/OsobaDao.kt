package com.example.lietajte_s_nami.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface OsobaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(osoba: Osoba)

    @Query("SELECT * FROM osoby")
    suspend fun getAll(): List<Osoba>

    @Query("SELECT * FROM osoby ORDER BY id DESC")
    fun getAllStream(): Flow<List<Osoba>>
}
