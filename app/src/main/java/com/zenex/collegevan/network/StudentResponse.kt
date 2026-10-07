package com.zenex.collegevan.network

data class StudentResponse(
    val studentId: String,
    val studentName: String,
    val department: String,
    val year: String,
    val vanId: String,
    val photoUrl: String = ""
)