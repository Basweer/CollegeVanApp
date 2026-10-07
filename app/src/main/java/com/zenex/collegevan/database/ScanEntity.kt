package com.zenex.collegevan.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scan_history")
data class ScanEntity(
    @PrimaryKey(autoGenerate = true)
    val scanId: Int = 0,
    val studentId: String,
    val studentName: String,
    val driverId: String,
    val vanId: String,
    val date: String,
    val time: String,
    val status: String,
    val syncStatus: String = "PENDING"
)