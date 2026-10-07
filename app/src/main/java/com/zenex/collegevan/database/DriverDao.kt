package com.zenex.collegevan.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DriverDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDriver(driver: DriverEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrivers(drivers: List<DriverEntity>)

    @Query("SELECT * FROM drivers WHERE driverId = :driverId LIMIT 1")
    suspend fun getDriver(driverId: String): DriverEntity?

    @Query("""
        SELECT * FROM drivers
        WHERE driverId = :driverId
        AND password = :password
        LIMIT 1
    """)
    suspend fun loginDriver(
        driverId: String,
        password: String
    ): DriverEntity?

    @Query("SELECT * FROM drivers")
    suspend fun getAllDrivers(): List<DriverEntity>

    @Query("DELETE FROM drivers WHERE driverId = :driverId")
    suspend fun deleteDriver(driverId: String)
}