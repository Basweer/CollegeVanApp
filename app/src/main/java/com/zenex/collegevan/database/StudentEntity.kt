package com.zenex.collegevan.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class StudentEntity(
    @PrimaryKey
    val studentId: String,
    val studentName: String,
    val department: String,
    val year: String,
    val vanId: String,
    val photoUrl: String = ""
)