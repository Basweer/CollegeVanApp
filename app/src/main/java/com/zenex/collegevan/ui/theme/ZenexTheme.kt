package com.zenex.collegevan.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

// ---------------------------------------------------------
// ZENEX LIGHT COLORS
// ---------------------------------------------------------
private val ZenexLightColors = lightColorScheme(

    primary = Color(0xFF5146C7),
    onPrimary = Color.White,

    primaryContainer = Color(0xFFE8E5FF),
    onPrimaryContainer = Color(0xFF29258A),

    secondary = Color(0xFF6257D8),
    onSecondary = Color.White,

    secondaryContainer = Color(0xFFECE9FF),
    onSecondaryContainer = Color(0xFF302A70),

    tertiary = Color(0xFF315FEA),
    onTertiary = Color.White,

    tertiaryContainer = Color(0xFFE1E8FF),
    onTertiaryContainer = Color(0xFF172A68),

    background = Color(0xFFF7F6FF),
    onBackground = Color(0xFF29258A),

    surface = Color.White,
    onSurface = Color(0xFF29258A),

    surfaceVariant = Color(0xFFF0EEFA),
    onSurfaceVariant = Color(0xFF5E5A73),

    outline = Color(0xFF8C87A8),
    outlineVariant = Color(0xFFD8D4E8),

    error = Color(0xFFD32F2F),
    onError = Color.White,

    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002)
)

// ---------------------------------------------------------
// ZENEX DARK COLORS
// ---------------------------------------------------------
private val ZenexDarkColors = darkColorScheme(

    primary = Color(0xFFBDB5FF),
    onPrimary = Color(0xFF29206F),

    primaryContainer = Color(0xFF3D348C),
    onPrimaryContainer = Color(0xFFE8E5FF),

    secondary = Color(0xFFC9C1FF),
    onSecondary = Color(0xFF32276F),

    secondaryContainer = Color(0xFF4A4196),
    onSecondaryContainer = Color(0xFFECE9FF),

    tertiary = Color(0xFFAFC2FF),
    onTertiary = Color(0xFF09215F),

    tertiaryContainer = Color(0xFF24438F),
    onTertiaryContainer = Color(0xFFE1E8FF),

    background = Color(0xFF12111A),
    onBackground = Color(0xFFE9E6F5),

    surface = Color(0xFF181720),
    onSurface = Color(0xFFE9E6F5),

    surfaceVariant = Color(0xFF454351),
    onSurfaceVariant = Color(0xFFC7C3D2),

    outline = Color(0xFF918D9D),
    outlineVariant = Color(0xFF454351),

    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),

    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6)
)

// ---------------------------------------------------------
// ZENEX TYPOGRAPHY
// ---------------------------------------------------------
private val ZenexTypography = Typography(

    headlineLarge = androidx.compose.ui.text.TextStyle(
        fontWeight = FontWeight.Bold
    ),

    headlineMedium = androidx.compose.ui.text.TextStyle(
        fontWeight = FontWeight.Bold
    ),

    headlineSmall = androidx.compose.ui.text.TextStyle(
        fontWeight = FontWeight.Bold
    ),

    titleLarge = androidx.compose.ui.text.TextStyle(
        fontWeight = FontWeight.Bold
    ),

    titleMedium = androidx.compose.ui.text.TextStyle(
        fontWeight = FontWeight.SemiBold
    ),

    titleSmall = androidx.compose.ui.text.TextStyle(
        fontWeight = FontWeight.SemiBold
    ),

    bodyLarge = androidx.compose.ui.text.TextStyle(
        fontWeight = FontWeight.Normal
    ),

    bodyMedium = androidx.compose.ui.text.TextStyle(
        fontWeight = FontWeight.Normal
    ),

    labelLarge = androidx.compose.ui.text.TextStyle(
        fontWeight = FontWeight.Bold
    ),

    labelMedium = androidx.compose.ui.text.TextStyle(
        fontWeight = FontWeight.SemiBold
    ),

    labelSmall = androidx.compose.ui.text.TextStyle(
        fontWeight = FontWeight.Medium
    )
)

// ---------------------------------------------------------
// ZENEX THEME
// ---------------------------------------------------------
@Composable
fun ZenexTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) {
        ZenexDarkColors
    } else {
        ZenexLightColors
    }

    MaterialTheme(
        colorScheme = colors,
        typography = ZenexTypography,
        content = content
    )
}