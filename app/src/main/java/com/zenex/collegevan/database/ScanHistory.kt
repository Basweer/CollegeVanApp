package com.zenex.collegevan.database

data class ScanHistory(
    val scanId: String = "",
    val studentId: String = "",
    val studentName: String = "",
    val driverId: String = "",
    val vanId: String = "",
    val date: String = "",
    val time: String = "",
    val status: String = ""
)