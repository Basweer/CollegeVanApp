package com.zenex.collegevan.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.zenex.collegevan.screens.DashboardScreen
import com.zenex.collegevan.screens.LoginScreen
import com.zenex.collegevan.screens.ProfileScreen
import com.zenex.collegevan.screens.QRScannerScreen
import com.zenex.collegevan.screens.ScanHistoryScreen
import com.zenex.collegevan.screens.ScanRecord
import com.zenex.collegevan.screens.StudentScreen

@Composable
fun AppNavigation() {

    val currentScreen = remember {
        mutableStateOf("login")
    }

    val driverId = remember {
        mutableStateOf("")
    }

    val driverName = remember {
        mutableStateOf("Driver")
    }

    val vanId = remember {
        mutableStateOf("VAN001")
    }

    val studentId = remember {
        mutableStateOf("")
    }

    when (currentScreen.value) {

        "login" -> {

            LoginScreen(
                onLoginSuccess = {
                    driverId.value = "DRV001"
                    driverName.value = "Driver"
                    vanId.value = "VAN001"

                    currentScreen.value = "dashboard"
                }
            )
        }

        "dashboard" -> {

            DashboardScreen(
                driverId = driverId.value,

                onScanClick = {
                    currentScreen.value = "scanner"
                },

                onHistoryClick = {
                    currentScreen.value = "history"
                },

                onProfileClick = {
                    currentScreen.value = "profile"
                },

                onLogoutClick = {
                    currentScreen.value = "login"
                }
            )
        }

        "scanner" -> {

            QRScannerScreen(
                onStudentFound = { id ->
                    studentId.value = id
                    currentScreen.value = "student"
                },

                onBackClick = {
                    currentScreen.value = "dashboard"
                }
            )
        }

        "student" -> {

            StudentScreen(
                studentId = studentId.value,
                studentName = "Test Student",
                department = "MCA",
                year = "2nd Year",
                vanId = vanId.value,

                onBackClick = {
                    currentScreen.value = "dashboard"
                }
            )
        }

        "history" -> {

            ScanHistoryScreen(
                scanHistory = listOf(
                    ScanRecord(
                        studentId = "STU001",
                        studentName = "Test Student",
                        vanId = "VAN001",
                        date = "2026-09-25",
                        time = "10:30 AM",
                        status = "Boarded"
                    )
                ),

                onBackClick = {
                    currentScreen.value = "dashboard"
                }
            )
        }

        "profile" -> {

            ProfileScreen(
                driverId = driverId.value,
                driverName = driverName.value,
                vanId = vanId.value,

                onBackClick = {
                    currentScreen.value = "dashboard"
                }
            )
        }
    }
}