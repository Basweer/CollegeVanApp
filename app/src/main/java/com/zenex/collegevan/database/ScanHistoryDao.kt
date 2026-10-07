package com.zenex.collegevan.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ScanHistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertScan(scan: ScanEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertScans(scans: List<ScanEntity>)

    @Query("SELECT * FROM scan_history ORDER BY scanId DESC")
    suspend fun getAllScans(): List<ScanEntity>

    @Query("SELECT * FROM scan_history WHERE driverId = :driverId ORDER BY scanId DESC")
    suspend fun getScansByDriver(driverId: String): List<ScanEntity>

    @Query("SELECT * FROM scan_history WHERE studentId = :studentId ORDER BY scanId DESC")
    suspend fun getScansByStudent(studentId: String): List<ScanEntity>

    @Query("SELECT * FROM scan_history WHERE syncStatus = 'PENDING'")
    suspend fun getPendingScans(): List<ScanEntity>

    @Query("""
        UPDATE scan_history
        SET syncStatus = :syncStatus
        WHERE scanId = :scanId
    """)
    suspend fun updateSyncStatus(
        scanId: Int,
        syncStatus: String
    )
}