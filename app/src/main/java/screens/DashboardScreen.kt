package com.zenex.collegevan.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zenex.collegevan.R
@Composable
fun DashboardScreen(
    driverId: String,
    onScanClick: () -> Unit,
    onHistoryClick: () -> Unit,
    onProfileClick: () -> Unit,
    onLogoutClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE5EEFF),
                        Color(0xFFF4F7FF),
                        Color.White,
                        Color(0xFFF2EDFF)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    start = 18.dp,
                    end = 18.dp,
                    top = 60.dp,
                    bottom = 20.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // =====================================================
            // Zenex LOGO
            // =====================================================

            Image(
                painter = painterResource(
                    id = R.drawable.zenexlogo
                ),
                contentDescription = "Zenex Logo",
                modifier = Modifier.size(90.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            // =====================================================
            // BRAND NAME
            // =====================================================

            Text(
                text = "Zenex Vision",
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF171D55),
                letterSpacing = 1.sp,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = "STUDENT TRANSPORT MANAGEMENT",
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF164A9C),
                letterSpacing = 1.2.sp,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = "Smart Transport, Safe Students",
                fontSize = 12.sp,
                color = Color(0xFF68728A),
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            // =====================================================
            // DRIVER CARD
            // =====================================================

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 500.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 7.dp
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .background(
                                color = Color(0xFFE3ECFF),
                                shape = RoundedCornerShape(17.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Image(
                            painter = painterResource(
                                id = R.drawable.driverlogo1
                            ),
                            contentDescription = "Driver Logo",
                            modifier = Modifier.size(51.dp),
                            contentScale = ContentScale.Fit
                        )
                    }

                    Spacer(
                        modifier = Modifier.width(12.dp)
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "Welcome, Driver",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF737C96)
                        )

                        Spacer(
                            modifier = Modifier.height(2.dp)
                        )

                        Text(
                            text = driverId,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF202D70)
                        )

                        Spacer(
                            modifier = Modifier.height(2.dp)
                        )

                        Text(
                            text = "Transport session is active",
                            fontSize = 9.sp,
                            color = Color(0xFF737C96)
                        )
                    }

                    // ACTIVE STATUS

                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(0xFFE3F7ED),
                                shape = RoundedCornerShape(18.dp)
                            )
                            .padding(
                                horizontal = 9.dp,
                                vertical = 6.dp
                            )
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(7.dp)
                                    .background(
                                        color = Color(0xFF24A35A),
                                        shape = CircleShape
                                    )
                            )

                            Spacer(
                                modifier = Modifier.width(4.dp)
                            )

                            Text(
                                text = "Active",
                                fontSize = 8.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF218838)
                            )
                        }
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            // =====================================================
            // SERVICES TITLE
            // =====================================================

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Transport Services",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF202D70)
                    )

                    Spacer(
                        modifier = Modifier.height(2.dp)
                    )

                    Text(
                        text = "Manage your daily van activities",
                        fontSize = 9.sp,
                        color = Color(0xFF737C96)
                    )
                }

                Box(
                    modifier = Modifier
                        .background(
                            color = Color(0xFFDCE8FF),
                            shape = RoundedCornerShape(9.dp)
                        )
                        .padding(
                            horizontal = 9.dp,
                            vertical = 5.dp
                        )
                ) {

                    Text(
                        text = "DRIVER",
                        fontSize = 7.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF315FEA)
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            // =====================================================
            // QR SCANNING
            // =====================================================

            DashboardCard(
                imageResource = R.drawable.qrscanning,
                title = "QR Code Scanning",
                subtitle = "Scan student QR code",
                info1 = "Student QR",
                info2 = "Boarding",
                status = "● Camera Ready",
                buttonText = "SCAN",
                buttonColor = Color(0xFF2463E9),
                onClick = onScanClick
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            // =====================================================
            // HISTORY
            // =====================================================

            DashboardCard(
                imageResource = R.drawable.qrhistory,
                title = "Scanned History",
                subtitle = "View previously scanned students",
                info1 = "Scan Records",
                info2 = "Date & Time",
                status = "● Scan Records",
                buttonText = "VIEW",
                buttonColor = Color(0xFF5B52C7),
                onClick = onHistoryClick
            )

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            // =====================================================
            // QUICK ACCESS
            // =====================================================

            Text(
                text = "Quick Access",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF202D70)
            )

            Spacer(
                modifier = Modifier.height(7.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.97f)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 14.dp,
                            horizontal = 5.dp
                        ),
                    horizontalArrangement =
                        Arrangement.SpaceEvenly
                ) {

                    DashboardQuickFeature(
                        icon = "▣",
                        title = "QR Scan",
                        subtitle = "Student"
                    )

                    DashboardQuickFeature(
                        icon = "⌖",
                        title = "Tracking",
                        subtitle = "Van"
                    )

                    DashboardQuickFeature(
                        icon = "◴",
                        title = "History",
                        subtitle = "Scans"
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            // =====================================================
            // LOGOUT
            // =====================================================

            OutlinedButton(
                onClick = onLogoutClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color(0xFFD32F2F)
                )
            ) {

                Text(
                    text = "Logout",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            // =====================================================
            // FOOTER
            // =====================================================

            Text(
                text = "Smart rides, smart tracks, peace of mind.",
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF164A9C),
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = "Powered by Zenex Vision",
                fontSize = 8.sp,
                color = Color(0xFF737C96),
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = "© 2026 ZVBT. All rights reserved.",
                fontSize = 8.sp,
                color = Color(0xFF737C96),
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )
        }
    }
}


// =========================================================
// DASHBOARD CARD
// =========================================================

@Composable
private fun DashboardCard(
    imageResource: Int,
    title: String,
    subtitle: String,
    info1: String,
    info2: String,
    status: String,
    buttonText: String,
    buttonColor: Color,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(19.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(61.dp)
                    .background(
                        color = Color(0xFFE4ECFF),
                        shape = RoundedCornerShape(15.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(
                        id = imageResource
                    ),
                    contentDescription = title,
                    modifier = Modifier
                        .size(53.dp)
                        .clip(
                            RoundedCornerShape(13.dp)
                        ),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(
                modifier = Modifier.width(11.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = title,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF202D70)
                )

                Spacer(
                    modifier = Modifier.height(2.dp)
                )

                Text(
                    text = subtitle,
                    fontSize = 9.sp,
                    color = Color(0xFF737C96)
                )

                Spacer(
                    modifier = Modifier.height(5.dp)
                )

                Row(
                    horizontalArrangement =
                        Arrangement.spacedBy(4.dp)
                ) {

                    DashboardChip(
                        text = info1
                    )

                    DashboardChip(
                        text = info2
                    )
                }

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = status,
                    fontSize = 7.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF218838)
                )
            }

            Spacer(
                modifier = Modifier.width(5.dp)
            )

            Button(
                onClick = onClick,
                modifier = Modifier.height(38.dp),
                shape = RoundedCornerShape(11.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor
                ),
                contentPadding = PaddingValues(
                    horizontal = 13.dp,
                    vertical = 0.dp
                )
            ) {

                Text(
                    text = buttonText,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}


// =========================================================
// DASHBOARD CHIP
// =========================================================

@Composable
private fun DashboardChip(
    text: String
) {

    Box(
        modifier = Modifier
            .background(
                color = Color(0xFFEFF4FF),
                shape = RoundedCornerShape(6.dp)
            )
            .padding(
                horizontal = 5.dp,
                vertical = 3.dp
            )
    ) {

        Text(
            text = text,
            fontSize = 6.sp,
            color = Color(0xFF315FEA),
            fontWeight = FontWeight.Medium
        )
    }
}


// =========================================================
// QUICK ACCESS FEATURE
// =========================================================

@Composable
private fun DashboardQuickFeature(
    icon: String,
    title: String,
    subtitle: String
) {

    Column(
        horizontalAlignment =
            Alignment.CenterHorizontally,
        modifier = Modifier.width(85.dp)
    ) {

        Box(
            modifier = Modifier
                .size(44.dp)
                .background(
                    color = Color(0xFFDCE8FF),
                    shape = RoundedCornerShape(13.dp)
                ),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = icon,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF174AA8)
            )
        }

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        Text(
            text = title,
            fontSize = 8.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF202D70)
        )

        Spacer(
            modifier = Modifier.height(2.dp)
        )

        Text(
            text = subtitle,
            fontSize = 7.sp,
            color = Color(0xFF737C96)
        )
    }
}