package com.zenex.collegevan.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.zenex.collegevan.database.AppDatabase
import com.zenex.collegevan.database.StudentEntity

@Composable
fun StudentScreen(
    studentId: String,
    onBackClick: () -> Unit
) {
    val context = LocalContext.current

    var student by remember {
        mutableStateOf<StudentEntity?>(null)
    }

    var loading by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(studentId) {
        val database = AppDatabase.getDatabase(context)

        student = database.studentDao().getStudent(studentId)

        loading = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("STUDENT DETAILS")

        Spacer(modifier = Modifier.height(24.dp))

        if (loading) {

            Text("Loading student details...")

        } else if (student != null) {

            Text("Student ID: ${student!!.studentId}")

            Spacer(modifier = Modifier.height(8.dp))

            Text("Name: ${student!!.studentName}")

            Spacer(modifier = Modifier.height(8.dp))

            Text("Department: ${student!!.department}")

            Spacer(modifier = Modifier.height(8.dp))

            Text("Year: ${student!!.year}")

            Spacer(modifier = Modifier.height(8.dp))

            Text("Van ID: ${student!!.vanId}")

        } else {

            Text("Student not found in local database.")

            Spacer(modifier = Modifier.height(8.dp))

            Text("Please sync student data before scanning.")

        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}