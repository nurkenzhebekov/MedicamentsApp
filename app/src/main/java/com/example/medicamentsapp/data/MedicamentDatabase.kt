package com.example.medicamentsapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Medicament::class], version = 1)
abstract class MedicamentDatabase : RoomDatabase() {

    abstract fun medicamentDao(): MedicamentDao

    companion object {
        @Volatile
        private var INSTANCE: MedicamentDatabase? = null

        fun getDatabase(context: Context): MedicamentDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MedicamentDatabase::class.java,
                    "medicament_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}