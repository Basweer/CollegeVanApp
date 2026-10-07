package com.zenex.collegevan.network

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    // Download students for a particular van
    @GET("students")
    suspend fun getStudents(
        @Query("vanId") vanId: String
    ): List<StudentResponse>

    // Upload a scanned student record
    @POST("scans")
    suspend fun uploadScan(
        @Body scan: ScanUploadRequest
    )
}