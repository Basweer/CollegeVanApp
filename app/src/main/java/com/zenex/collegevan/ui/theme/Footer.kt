package com.zenex.collegevan.ui.theme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import java.util.Calendar

@Composable
fun ZenexFooter() {

    val currentYear = Calendar.getInstance().get(Calendar.YEAR)

    Text(
        text = "© 2026 - $currentYear ZVBT. All rights reserved.",
        fontSize = 11.sp,
        color = Color.Gray
    )
}