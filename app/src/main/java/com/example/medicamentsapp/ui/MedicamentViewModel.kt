package com.example.medicamentsapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.medicamentsapp.data.Medicament
import com.example.medicamentsapp.data.MedicamentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MedicamentViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: MedicamentRepository = MedicamentRepository(application)
    val medicaments: LiveData<List<Medicament>> = repository.allMedicaments

    fun insert(medicament: Medicament) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(medicament)
    }
}