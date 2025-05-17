package com.example.lietajte_s_nami.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lietajte_s_nami.data.Osoba
import com.example.lietajte_s_nami.data.OsobaDao

@Database(entities = [Osoba::class], version = 1, exportSchema = false)
abstract class OsobaDatabase : RoomDatabase() {
    abstract fun osobaDao(): OsobaDao

    companion object {
        @Volatile
        private var INSTANCE: OsobaDatabase? = null

        fun getDatabase(context: Context): OsobaDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    OsobaDatabase::class.java,
                    "osoby_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
