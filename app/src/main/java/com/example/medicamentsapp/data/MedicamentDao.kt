package com.example.medicamentsapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MedicamentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(medicament: Medicament)

    @Query("SELECT * FROM medicaments")
    fun getAllMedicaments(): LiveData<List<Medicament>>
}