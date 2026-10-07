package com.zenex.collegevan.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface VanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVan(van: VanEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVans(vans: List<VanEntity>)

    @Query("SELECT * FROM vans WHERE vanId = :vanId LIMIT 1")
    suspend fun getVan(vanId: String): VanEntity?

    @Query("SELECT * FROM vans")
    suspend fun getAllVans(): List<VanEntity>

    @Query("SELECT * FROM vans WHERE driverId = :driverId LIMIT 1")
    suspend fun getVanByDriver(driverId: String): VanEntity?

    @Query("DELETE FROM vans WHERE vanId = :vanId")
    suspend fun deleteVan(vanId: String)
}