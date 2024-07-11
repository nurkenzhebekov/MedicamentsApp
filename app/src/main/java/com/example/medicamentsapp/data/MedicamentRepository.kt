package com.example.medicamentsapp.data

import android.app.Application
import androidx.lifecycle.LiveData

class MedicamentRepository(application: Application) {

    private val medicamentDao: MedicamentDao
    val allMedicaments: LiveData<List<Medicament>>

    init {
        val database = MedicamentDatabase.getDatabase(application)
        medicamentDao = database.medicamentDao()
        allMedicaments = medicamentDao.getAllMedicaments()
    }

    suspend fun insert(medicament: Medicament) {
        medicamentDao.insert(medicament)
    }
}