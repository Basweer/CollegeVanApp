package com.zenex.collegevan.navigation

import androidx.annotation.OptIn
import androidx.camera.core.ExperimentalGetImage
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.zenex.collegevan.screens.DashboardScreen
import com.zenex.collegevan.screens.LoginScreen
import com.zenex.collegevan.screens.ProfileScreen
import com.zenex.collegevan.screens.QRScannerScreen
import com.zenex.collegevan.screens.ScanHistoryScreen
import com.zenex.collegevan.screens.StudentScreen

@OptIn(markerClass = [ExperimentalGetImage::class])
@Composable
fun AppNavigation() {

    val context = LocalContext.current

    val currentScreen = remember { mutableStateOf("login") }

    val driverId = remember { mutableStateOf("") }
    val driverName = remember { mutableStateOf("") }
    val vanId = remember { mutableStateOf("") }

    val studentId = remember { mutableStateOf("") }

    when (currentScreen.value) {

        "login" -> {

            LoginScreen(
                context = context,

                onLoginSuccess = { loggedInDriverId, loggedInDriverName, loggedInVanId ->

                    driverId.value = loggedInDriverId
                    driverName.value = loggedInDriverName
                    vanId.value = loggedInVanId

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

                    driverId.value = ""
                    driverName.value = ""
                    vanId.value = ""
                    studentId.value = ""

                    currentScreen.value = "login"
                }
            )
        }

        "scanner" -> {

            QRScannerScreen(
                driverId = driverId.value,
                vanId = vanId.value,

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

                onBackClick = {
                    currentScreen.value = "dashboard"
                }
            )
        }

        "history" -> {

            ScanHistoryScreen(
                driverId = driverId.value,

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