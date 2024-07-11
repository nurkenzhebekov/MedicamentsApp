package com.example.medicamentsapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.medicamentsapp.utils.Importance

@Entity(tableName = "medicaments")
data class Medicament(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val time: String,
    val importance: Importance
)