package com.example.lietajte_s_nami

import android.app.Application
import com.example.lietajte_s_nami.data.OsobaRepository
import com.example.lietajte_s_nami.data.OsobaDatabase

class LietajteSNamiApplication : Application() {
    lateinit var osobaRepository: OsobaRepository
        private set

    override fun onCreate() { super.onCreate()
        val database = OsobaDatabase.getDatabase(this)
        osobaRepository = OsobaRepository(database.osobaDao())
    }
}