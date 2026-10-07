package com.zenex.collegevan.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun ProfileScreen(
    driverId: String,
    driverName: String,
    vanId: String,
    onBackClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE9E7FF),
                        Color(0xFFF7F6FF),
                        Color.White
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 20.dp,
                    vertical = 18.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(
                    id = R.drawable.zenexlogo
                ),
                contentDescription = "Zenex College Logo",
                modifier = Modifier.size(65.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            Text(
                text = "ZENEX COLLEGE VAN",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF29258A),
                textAlign = TextAlign.Center
            )

            Text(
                text = "DRIVER PROFILE",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5B54A4),
                letterSpacing = 1.2.sp
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            // DRIVER IMAGE

            Card(
                modifier = Modifier.size(150.dp),
                shape = RoundedCornerShape(25.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                )
            ) {

                Image(
                    painter = painterResource(
                        id = R.drawable.driverlogo1
                    ),
                    contentDescription = "Driver Profile",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            Text(
                text = driverName.ifBlank {
                    "Driver"
                },
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF29258A),
                textAlign = TextAlign.Center
            )

            Text(
                text = "College Van Driver",
                fontSize = 12.sp,
                color = Color.Gray
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            // DRIVER DETAILS

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp)
                ) {

                    Text(
                        text = "DRIVER INFORMATION",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF37327D),
                        letterSpacing = 1.sp
                    )

                    Spacer(
                        modifier = Modifier.height(15.dp)
                    )

                    ProfileDetailRow(
                        label = "Driver ID",
                        value = driverId
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                    ProfileDetailRow(
                        label = "Driver Name",
                        value = driverName
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                    ProfileDetailRow(
                        label = "Van ID",
                        value = vanId
                    )
                }
            }

            Spacer(
                modifier = Modifier.weight(1f)
            )

            // BACK BUTTON

            Button(
                onClick = onBackClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5146C7)
                )
            ) {

                Text(
                    text = "BACK TO DASHBOARD",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                text = "Smart Data, Bright Future",
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF514BA0)
            )


        }
    }
}

@Composable
private fun ProfileDetailRow(
    label: String,
    value: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = label,
                fontSize = 10.sp,
                color = Color.Gray
            )

            Spacer(
                modifier = Modifier.height(2.dp)
            )

            Text(
                text = value.ifBlank {
                    "Not Available"
                },
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF29258A)
            )
        }

        Spacer(
            modifier = Modifier.width(8.dp)
        )
    }
}