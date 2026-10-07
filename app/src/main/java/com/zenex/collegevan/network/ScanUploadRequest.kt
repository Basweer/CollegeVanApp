package com.zenex.collegevan.network

data class ScanUploadRequest(
    val studentId: String,
    val studentName: String,
    val driverId: String,
    val vanId: String,
    val date: String,
    val time: String,
    val status: String
)