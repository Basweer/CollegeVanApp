package com.zenex.collegevan.screens

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.OptIn
import androidx.camera.core.CameraSelector
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.core.content.ContextCompat
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import com.zenex.collegevan.database.AppDatabase
import com.zenex.collegevan.database.ScanEntity
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean

@OptIn(markerClass = [ExperimentalGetImage::class])
@Composable
fun QRScannerScreen(
    driverId: String,
    vanId: String,
    onStudentFound: (String) -> Unit,
    onBackClick: () -> Unit
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val coroutineScope = rememberCoroutineScope()

    var hasCameraPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    var decodedValue by remember {
        mutableStateOf("")
    }

    var saveMessage by remember {
        mutableStateOf("")
    }

    val scannerStarted = remember {
        AtomicBoolean(false)
    }

    val permissionLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { granted ->
            hasCameraPermission = granted
        }

    LaunchedEffect(Unit) {
        if (!hasCameraPermission) {
            permissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Scan Student QR Code")

        Spacer(modifier = Modifier.height(12.dp))

        if (hasCameraPermission) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {

                AndroidView(
                    factory = { ctx ->

                        val previewView = PreviewView(ctx)

                        val cameraProviderFuture =
                            ProcessCameraProvider.getInstance(ctx)

                        cameraProviderFuture.addListener({

                            val cameraProvider =
                                cameraProviderFuture.get()

                            val preview =
                                Preview.Builder().build()

                            preview.surfaceProvider =
                                previewView.surfaceProvider

                            val imageAnalysis =
                                ImageAnalysis.Builder()
                                    .setBackpressureStrategy(
                                        ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST
                                    )
                                    .build()

                            val scanner =
                                BarcodeScanning.getClient()

                            val cameraExecutor =
                                Executors.newSingleThreadExecutor()

                            imageAnalysis.setAnalyzer(
                                cameraExecutor
                            ) { imageProxy ->

                                val mediaImage =
                                    imageProxy.image

                                if (mediaImage != null) {

                                    val image =
                                        InputImage.fromMediaImage(
                                            mediaImage,
                                            imageProxy.imageInfo.rotationDegrees
                                        )

                                    scanner.process(image)

                                        .addOnSuccessListener { barcodes ->

                                            for (barcode in barcodes) {

                                                val value =
                                                    barcode.rawValue

                                                if (
                                                    !value.isNullOrBlank() &&
                                                    scannerStarted.compareAndSet(
                                                        false,
                                                        true
                                                    )
                                                ) {

                                                    decodedValue = value

                                                    coroutineScope.launch {

                                                        saveScanToDatabase(
                                                            context = context,
                                                            studentId = value,
                                                            driverId = driverId,
                                                            vanId = vanId
                                                        )

                                                        saveMessage =
                                                            "Scan saved locally"

                                                        onStudentFound(value)
                                                    }

                                                    break
                                                }
                                            }
                                        }

                                        .addOnCompleteListener {
                                            imageProxy.close()
                                        }

                                } else {

                                    imageProxy.close()
                                }
                            }

                            cameraProvider.unbindAll()

                            cameraProvider.bindToLifecycle(
                                lifecycleOwner,
                                CameraSelector.DEFAULT_BACK_CAMERA,
                                preview,
                                imageAnalysis
                            )

                        }, ContextCompat.getMainExecutor(ctx))

                        previewView
                    },

                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            if (decodedValue.isNotEmpty()) {
                Text("Student ID: $decodedValue")
            } else {
                Text("Point the camera at a student QR code")
            }

            Spacer(modifier = Modifier.height(8.dp))

            if (saveMessage.isNotEmpty()) {
                Text(saveMessage)
            }

        } else {

            Text("Camera permission is required.")

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    permissionLauncher.launch(
                        Manifest.permission.CAMERA
                    )
                }
            ) {
                Text("Allow Camera")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}

private suspend fun saveScanToDatabase(
    context: Context,
    studentId: String,
    driverId: String,
    vanId: String
) {

    val database =
        AppDatabase.getDatabase(context)

    val student =
        database.studentDao().getStudent(studentId)

    val currentDate =
        SimpleDateFormat(
            "yyyy-MM-dd",
            Locale.getDefault()
        ).format(Date())

    val currentTime =
        SimpleDateFormat(
            "HH:mm:ss",
            Locale.getDefault()
        ).format(Date())

    val scan = ScanEntity(
        studentId = studentId,
        studentName = student?.studentName ?: "Unknown Student",
        driverId = driverId,
        vanId = vanId,
        date = currentDate,
        time = currentTime,
        status = "Boarded",
        syncStatus = "PENDING"
    )

    database.scanHistoryDao().insertScan(scan)
}