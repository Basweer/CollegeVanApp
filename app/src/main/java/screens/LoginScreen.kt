package com.zenex.collegevan.screens
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.zenex.collegevan.database.AppDatabase
import kotlinx.coroutines.launch
private object LoginLayout {
    const val SCREEN_LEFT = 20
    const val SCREEN_RIGHT = 20
    const val CONTENT_MAX_WIDTH = 460
    const val CONTENT_TOP = 100
    const val CONTENT_BOTTOM = 12
    const val LOGO_SIZE = 100
    const val LOGO_TOP = 5
    const val LOGO_BOTTOM = 4
    const val BRAND_NAME_TOP = 0
    const val BRAND_NAME_BOTTOM = 3
    const val INSTITUTION_BOTTOM = 5
    const val FORM_TOP = 20
    const val FORM_LEFT = 20
    const val FORM_RIGHT = 20
    const val FORM_TOP_PADDING = 20
    const val FORM_BOTTOM_PADDING = 20
    const val QUICK_ACCESS_TOP = 18
    const val QUICK_ACCESS_LEFT = 10
    const val QUICK_ACCESS_RIGHT = 10
    const val QUICK_ACCESS_TOP_PADDING = 13
    const val QUICK_ACCESS_BOTTOM_PADDING = 13
    const val STATUS_TOP = 10
    const val STATUS_BOTTOM = 6
    const val FOOTER_LEFT = 12
    const val FOOTER_RIGHT = 12
    const val FOOTER_TOP = 30
    const val FOOTER_BOTTOM = 30
    const val FORM_CORNER = 22
    const val QUICK_ACCESS_CORNER = 18 }
// COLORS
private val NavyBlue = Color(0xFF202D70)
private val PrimaryBlue = Color(0xFF4263EB)
private val Purple = Color(0xFF7161E8)
private val MutedText = Color(0xFF737C96)
private val BorderColor = Color(0xFFE3E8F5)
@Composable
fun LoginScreen(
    context: Context,
    onLoginSuccess: (
        driverId: String,
        driverName: String,
        vanId: String
    ) -> Unit
) {
    var driverId by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE7ECFF),
                        Color(0xFFF5F6FF),
                        Color(0xFFFCFCFF)
                    )
                )
            )
    ) {
        val compactScreen = maxHeight < 740.dp
        Column(modifier = Modifier.fillMaxSize()) {
            // SCROLLABLE MAIN CONTENT
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    modifier = Modifier
                        .widthIn(max = LoginLayout.CONTENT_MAX_WIDTH.dp)
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .padding(
                            start = LoginLayout.SCREEN_LEFT.dp,
                            end = LoginLayout.SCREEN_RIGHT.dp,
                            top = if (compactScreen) 8.dp
                            else LoginLayout.CONTENT_TOP.dp,
                            bottom = LoginLayout.CONTENT_BOTTOM.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // COLLEGE LOGO
                    Spacer(
                        modifier = Modifier.height(
                            LoginLayout.LOGO_TOP.dp
                        )
                    )
                    Image(
                        painter = painterResource(
                            id = R.drawable.zenexlogo
                        ),
                        contentDescription = "Zenex College Logo",
                        modifier = Modifier.size(
                            if (compactScreen) 64.dp
                            else LoginLayout.LOGO_SIZE.dp
                        ),
                        contentScale = ContentScale.Fit
                    )
                    Spacer(
                        modifier = Modifier.height(
                            LoginLayout.LOGO_BOTTOM.dp
                        )
                    )
                    // BRANDING
                    Spacer(
                        modifier = Modifier.height(
                            LoginLayout.BRAND_NAME_TOP.dp
                        )
                    )
                    Text(
                        text = "Zenex Vision",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = NavyBlue,
                        letterSpacing = 0.3.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(
                        modifier = Modifier.height(
                            LoginLayout.BRAND_NAME_BOTTOM.dp
                        )
                    )
                    Text(
                        text = "Group of Educational Institutional",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        color = Purple,
                        letterSpacing = 1.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(
                        modifier = Modifier.height(
                            LoginLayout.INSTITUTION_BOTTOM.dp
                        )
                    )
                    Text(
                        text = "Smart Transport • Safe Students",
                        fontSize = 12.sp,
                        color = MutedText,
                        textAlign = TextAlign.Center
                    )
                    Spacer(
                        modifier = Modifier.height(
                            if (compactScreen) 17.dp
                            else LoginLayout.FORM_TOP.dp
                        )
                    )
                    // LOGIN CARD
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(
                            LoginLayout.FORM_CORNER.dp
                        ),
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
                                .padding(
                                    start = LoginLayout.FORM_LEFT.dp,
                                    end = LoginLayout.FORM_RIGHT.dp,
                                    top = LoginLayout.FORM_TOP_PADDING.dp,
                                    bottom = LoginLayout.FORM_BOTTOM_PADDING.dp
                                )
                        ) {
                            Text(
                                text = "Driver Login",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = NavyBlue
                            )
                            Spacer(Modifier.height(5.dp))
                            Text(
                                text = "Sign in to manage your college van",
                                fontSize = 12.sp,
                                color = MutedText
                            )
                            Spacer(Modifier.height(22.dp))
                            Text(
                                text = "Driver ID",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.sp,
                                color = NavyBlue
                            )
                            Spacer(Modifier.height(8.dp))
                            OutlinedTextField(
                                value = driverId,
                                onValueChange = {
                                    driverId = it
                                    errorMessage = ""
                                },
                                placeholder = {
                                    Text(
                                        text = "Enter your Driver ID",
                                        fontSize = 13.sp,
                                        color = Color(0xFFA1A8BA)
                                    )
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .heightIn(min = 56.dp),
                                singleLine = true,
                                shape = RoundedCornerShape(14.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = PrimaryBlue,
                                    unfocusedBorderColor = BorderColor,
                                    focusedContainerColor = Color(0xFFFAFBFF),
                                    unfocusedContainerColor = Color(0xFFFAFBFF),
                                    focusedTextColor = NavyBlue,
                                    unfocusedTextColor = NavyBlue,
                                    cursorColor = PrimaryBlue
                                )
                            )
                            Spacer(Modifier.height(18.dp))
                            // EXISTING LOGIN LOGIC
                            Button(
                                onClick = {
                                    val enteredId = driverId
                                        .trim()
                                        .uppercase()
                                    if (enteredId.isEmpty()) {
                                        errorMessage =
                                            "Please enter Driver ID"
                                        return@Button
                                    }
                                    coroutineScope.launch {
                                        val database =
                                            AppDatabase.getDatabase(context)
                                        val driver = database
                                            .driverDao()
                                            .getDriver(enteredId)
                                        if (driver != null) {
                                            errorMessage = ""
                                            onLoginSuccess(
                                                driver.driverId,
                                                driver.driverName,
                                                driver.vanId
                                            )
                                        } else {
                                            errorMessage =
                                                "Invalid Driver ID"
                                        }
                                    }
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(54.dp),
                                shape = RoundedCornerShape(14.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = PrimaryBlue,
                                    contentColor = Color.White
                                ),
                                elevation = ButtonDefaults.buttonElevation(
                                    defaultElevation = 3.dp,
                                    pressedElevation = 1.dp
                                )
                            ) {
                                Text(
                                    text = "Sign in",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    letterSpacing = 1.sp
                                )
                            }
                            // ERROR MESSAGE
                            if (errorMessage.isNotEmpty()) {
                                Spacer(Modifier.height(10.dp))
                                Text(
                                    text = errorMessage,
                                    color = Color(0xFFD32F2F),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        }
                    }
                    // QUICK ACCESS SPACING
                    Spacer(
                        modifier = Modifier.height(
                            if (compactScreen) 14.dp
                            else LoginLayout.QUICK_ACCESS_TOP.dp
                        )
                    )
                    // QUICK ACCESS CARD
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(
                            LoginLayout.QUICK_ACCESS_CORNER.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White.copy(alpha = 0.96f)
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 2.dp
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = LoginLayout.QUICK_ACCESS_LEFT.dp,
                                    end = LoginLayout.QUICK_ACCESS_RIGHT.dp,
                                    top = LoginLayout.QUICK_ACCESS_TOP_PADDING.dp,
                                    bottom = LoginLayout.QUICK_ACCESS_BOTTOM_PADDING.dp
                                )
                        ) {
                            Text(
                                text = "Quick Access",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                letterSpacing = 1.5.sp,
                                color = NavyBlue,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(Modifier.height(15.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                FeatureItem(
                                    icon = "🔳",
                                    title = "QR Scan",
                                    subtitle = "Student",
                                    iconColor = Color(0xFF4263EB),
                                    iconBackground = Color(0xFFE9EEFF)
                                )
                                FeatureItem(
                                    icon = "📍",
                                    title = "Tracking",
                                    subtitle = "Van",
                                    iconColor = Color(0xFF159D87),
                                    iconBackground = Color(0xFFE3F7F2)
                                )
                                FeatureItem(
                                    icon = "🕘",
                                    title = "History",
                                    subtitle = "Scans",
                                    iconColor = Color(0xFF8A58D6),
                                    iconBackground = Color(0xFFF1E8FF)
                                )
                            }
                        }
                    }
                    // STATUS
                    Spacer(
                        modifier = Modifier.height(
                            LoginLayout.STATUS_TOP.dp
                        )
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(7.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF25A56A))
                        )
                        Spacer(Modifier.width(7.dp))
                        Text(
                            text = "College Van Tracking System",
                            fontSize = 10.sp,
                            color = MutedText
                        )
                    }
                    Spacer(
                        modifier = Modifier.height(
                            LoginLayout.STATUS_BOTTOM.dp
                        )
                    )
                }
            }
            // FOOTER - BOTTOM OF SCREEN
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White.copy(alpha = 0.96f))
                    .padding(
                        start = LoginLayout.FOOTER_LEFT.dp,
                        end = LoginLayout.FOOTER_RIGHT.dp,
                        top = LoginLayout.FOOTER_TOP.dp,
                        bottom = LoginLayout.FOOTER_BOTTOM.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Powered by Zenex Vision, Driven by Trust.",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = NavyBlue,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "© 2026 ZVBT. All rights reserved.",
                    fontSize = 10.sp,
                    color = MutedText,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
// QUICK ACCESS FEATURE ITEM
@Composable
fun FeatureItem(
    icon: String,
    title: String,
    subtitle: String,
    iconColor: Color = Color(0xFF5146C7),
    iconBackground: Color = Color(0xFFEAE8FF)
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(82.dp)
    ) {
        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(RoundedCornerShape(13.dp))
                .background(iconBackground),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = icon,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = iconColor
            )
        }
        Spacer(Modifier.height(7.dp))
        Text(
            text = title,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = NavyBlue,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(2.dp))
        Text(
            text = subtitle,
            fontSize = 9.sp,
            color = MutedText,
            textAlign = TextAlign.Center
        )
    }
}