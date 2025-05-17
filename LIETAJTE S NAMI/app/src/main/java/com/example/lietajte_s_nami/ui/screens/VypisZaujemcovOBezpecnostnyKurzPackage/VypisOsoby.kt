package com.example.lietajte_s_nami.screens.VypisZaujemcovOBezpecnostnyKurzPackage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.lietajte_s_nami.data.Osoba
import com.example.lietajte_s_nami.data.OsobaRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class VypisOsobViewModel(
    osobaRepository: OsobaRepository
) : ViewModel() {
    val osoby: StateFlow<List<Osoba>> =
        osobaRepository.osobyStream.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )
}

class VypisOsobViewModelFactory(
    private val osobaRepository: OsobaRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VypisOsobViewModel(osobaRepository) as T
    }
}
