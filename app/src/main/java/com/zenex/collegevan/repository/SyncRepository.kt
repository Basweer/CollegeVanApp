package com.zenex.collegevan.repository

import com.zenex.collegevan.database.AppDatabase
import com.zenex.collegevan.database.ScanEntity
import com.zenex.collegevan.database.StudentEntity
import com.zenex.collegevan.network.ApiClient
import com.zenex.collegevan.network.ScanUploadRequest

class SyncRepository(
    private val database: AppDatabase
) {

    private val api = ApiClient.apiService

    /**
     * Download students for the driver's van
     * and save them into the local Room database.
     */
    suspend fun downloadStudents(vanId: String): Result<Int> {

        return try {

            val students = api.getStudents(vanId)

            val entities = students.map { student ->

                StudentEntity(
                    studentId = student.studentId,
                    studentName = student.studentName,
                    department = student.department,
                    year = student.year,
                    vanId = student.vanId,
                    photoUrl = student.photoUrl
                )
            }

            database.studentDao().insertStudents(entities)

            Result.success(entities.size)

        } catch (e: Exception) {

            Result.failure(e)
        }
    }

    /**
     * Upload pending scans to the central API.
     */
    suspend fun uploadPendingScans(driverId: String): Result<Int> {

        return try {

            val scans = database
                .scanHistoryDao()
                .getPendingScans()
                .filter { it.driverId == driverId }

            var uploadedCount = 0

            for (scan in scans) {

                val request = ScanUploadRequest(
                    studentId = scan.studentId,
                    studentName = scan.studentName,
                    driverId = scan.driverId,
                    vanId = scan.vanId,
                    date = scan.date,
                    time = scan.time,
                    status = scan.status
                )

                api.uploadScan(request)

                database
                    .scanHistoryDao()
                    .updateSyncStatus(
                        scanId = scan.scanId,
                        syncStatus = "SYNCED"
                    )

                uploadedCount++
            }

            Result.success(uploadedCount)

        } catch (e: Exception) {

            Result.failure(e)
        }
    }
}