
package com.zenex.collegevan.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        StudentEntity::class,
        ScanEntity::class,
        DriverEntity::class,
        VanEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
    abstract fun scanHistoryDao(): ScanHistoryDao
    abstract fun driverDao(): DriverDao
    abstract fun vanDao(): VanDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "college_van_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}
