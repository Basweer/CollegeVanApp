package com.zenex.collegevan.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vans")
data class VanEntity(
    @PrimaryKey
    val vanId: String,
    val vanNumber: String,
    val driverId: String,
    val driverName: String,
    val route: String
)