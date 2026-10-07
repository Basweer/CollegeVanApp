package com.zenex.collegevan.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drivers")
data class DriverEntity(
    @PrimaryKey
    val driverId: String,
    val driverName: String,
    val password: String = "",
    val vanId: String
)