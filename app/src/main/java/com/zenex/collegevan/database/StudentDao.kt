package com.zenex.collegevan.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudents(students: List<StudentEntity>)

    @Query("SELECT * FROM students WHERE vanId = :vanId")
    suspend fun getStudentsByVan(vanId: String): List<StudentEntity>

    @Query("SELECT * FROM students WHERE studentId = :studentId LIMIT 1")
    suspend fun getStudent(studentId: String): StudentEntity?

    @Query("DELETE FROM students")
    suspend fun deleteAllStudents()
}