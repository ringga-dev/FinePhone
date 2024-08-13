package ngga.ring.finephone.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorsBlack = lightColorScheme(
    primary = md_theme_light_primary_black,
    onPrimary = md_theme_light_onPrimary_black,
    primaryContainer = md_theme_light_primaryContainer_black,
    onPrimaryContainer = md_theme_light_onPrimaryContainer_black,
    secondary = md_theme_light_secondary_black,
    onSecondary = md_theme_light_onSecondary_black,
    secondaryContainer = md_theme_light_secondaryContainer_black,
    onSecondaryContainer = md_theme_light_onSecondaryContainer_black,
    tertiary = md_theme_light_tertiary_black,
    onTertiary = md_theme_light_onTertiary_black,
    tertiaryContainer = md_theme_light_tertiaryContainer_black,
    onTertiaryContainer = md_theme_light_onTertiaryContainer_black,
    error = md_theme_light_error_black,
    errorContainer = md_theme_light_errorContainer_black,
    onError = md_theme_light_onError_black,
    onErrorContainer = md_theme_light_onErrorContainer_black,
    background = md_theme_light_background_black,
    onBackground = md_theme_light_onBackground_black,
    surface = md_theme_light_surface_black,
    onSurface = md_theme_light_onSurface_black,
    surfaceVariant = md_theme_light_surfaceVariant_black,
    onSurfaceVariant = md_theme_light_onSurfaceVariant_black,
    outline = md_theme_light_outline_black,
    inverseOnSurface = md_theme_light_inverseOnSurface_black,
    inverseSurface = md_theme_light_inverseSurface_black,
    inversePrimary = md_theme_light_inversePrimary_black,
    surfaceTint = md_theme_light_surfaceTint_black,
    outlineVariant = md_theme_light_outlineVariant_black,
    scrim = md_theme_light_scrim_black,
)


private val DarkColorsBlack = darkColorScheme(
    primary = md_theme_dark_primary_black,
    onPrimary = md_theme_dark_onPrimary_black,
    primaryContainer = md_theme_dark_primaryContainer_black,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer_black,
    secondary = md_theme_dark_secondary_black,
    onSecondary = md_theme_dark_onSecondary_black,
    secondaryContainer = md_theme_dark_secondaryContainer_black,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer_black,
    tertiary = md_theme_dark_tertiary_black,
    onTertiary = md_theme_dark_onTertiary_black,
    tertiaryContainer = md_theme_dark_tertiaryContainer_black,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer_black,
    error = md_theme_dark_error_black,
    errorContainer = md_theme_dark_errorContainer_black,
    onError = md_theme_dark_onError_black,
    onErrorContainer = md_theme_dark_onErrorContainer_black,
    background = md_theme_dark_background_black,
    onBackground = md_theme_dark_onBackground_black,
    surface = md_theme_dark_surface_black,
    onSurface = md_theme_dark_onSurface_black,
    surfaceVariant = md_theme_dark_surfaceVariant_black,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant_black,
    outline = md_theme_dark_outline_black,
    inverseOnSurface = md_theme_dark_inverseOnSurface_black,
    inverseSurface = md_theme_dark_inverseSurface_black,
    inversePrimary = md_theme_dark_inversePrimary_black,
    surfaceTint = md_theme_dark_surfaceTint_black,
    outlineVariant = md_theme_dark_outlineVariant_black,
    scrim = md_theme_dark_scrim_black,
)


private val LightColorsSilver = lightColorScheme(
    primary = md_theme_light_primary_silver,
    onPrimary = md_theme_light_onPrimary_silver,
    primaryContainer = md_theme_light_primaryContainer_silver,
    onPrimaryContainer = md_theme_light_onPrimaryContainer_silver,
    secondary = md_theme_light_secondary_silver,
    onSecondary = md_theme_light_onSecondary_silver,
    secondaryContainer = md_theme_light_secondaryContainer_silver,
    onSecondaryContainer = md_theme_light_onSecondaryContainer_silver,
    tertiary = md_theme_light_tertiary_silver,
    onTertiary = md_theme_light_onTertiary_silver,
    tertiaryContainer = md_theme_light_tertiaryContainer_silver,
    onTertiaryContainer = md_theme_light_onTertiaryContainer_silver,
    error = md_theme_light_error_silver,
    errorContainer = md_theme_light_errorContainer_silver,
    onError = md_theme_light_onError_silver,
    onErrorContainer = md_theme_light_onErrorContainer_silver,
    background = md_theme_light_background_silver,
    onBackground = md_theme_light_onBackground_silver,
    surface = md_theme_light_surface_silver,
    onSurface = md_theme_light_onSurface_silver,
    surfaceVariant = md_theme_light_surfaceVariant_silver,
    onSurfaceVariant = md_theme_light_onSurfaceVariant_silver,
    outline = md_theme_light_outline_silver,
    inverseOnSurface = md_theme_light_inverseOnSurface_silver,
    inverseSurface = md_theme_light_inverseSurface_silver,
    inversePrimary = md_theme_light_inversePrimary_silver,
    surfaceTint = md_theme_light_surfaceTint_silver,
    outlineVariant = md_theme_light_outlineVariant_silver,
    scrim = md_theme_light_scrim_silver,
)


private val DarkColorsSilver = darkColorScheme(
    primary = md_theme_dark_primary_silver,
    onPrimary = md_theme_dark_onPrimary_silver,
    primaryContainer = md_theme_dark_primaryContainer_silver,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer_silver,
    secondary = md_theme_dark_secondary_silver,
    onSecondary = md_theme_dark_onSecondary_silver,
    secondaryContainer = md_theme_dark_secondaryContainer_silver,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer_silver,
    tertiary = md_theme_dark_tertiary_silver,
    onTertiary = md_theme_dark_onTertiary_silver,
    tertiaryContainer = md_theme_dark_tertiaryContainer_silver,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer_silver,
    error = md_theme_dark_error_silver,
    errorContainer = md_theme_dark_errorContainer_silver,
    onError = md_theme_dark_onError_silver,
    onErrorContainer = md_theme_dark_onErrorContainer_silver,
    background = md_theme_dark_background_silver,
    onBackground = md_theme_dark_onBackground_silver,
    surface = md_theme_dark_surface_silver,
    onSurface = md_theme_dark_onSurface_silver,
    surfaceVariant = md_theme_dark_surfaceVariant_silver,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant_silver,
    outline = md_theme_dark_outline_silver,
    inverseOnSurface = md_theme_dark_inverseOnSurface_silver,
    inverseSurface = md_theme_dark_inverseSurface_silver,
    inversePrimary = md_theme_dark_inversePrimary_silver,
    surfaceTint = md_theme_dark_surfaceTint_silver,
    outlineVariant = md_theme_dark_outlineVariant_silver,
    scrim = md_theme_dark_scrim_silver,
)


private val LightColorsGray = lightColorScheme(
    primary = md_theme_light_primary_gray,
    onPrimary = md_theme_light_onPrimary_gray,
    primaryContainer = md_theme_light_primaryContainer_gray,
    onPrimaryContainer = md_theme_light_onPrimaryContainer_gray,
    secondary = md_theme_light_secondary_gray,
    onSecondary = md_theme_light_onSecondary_gray,
    secondaryContainer = md_theme_light_secondaryContainer_gray,
    onSecondaryContainer = md_theme_light_onSecondaryContainer_gray,
    tertiary = md_theme_light_tertiary_gray,
    onTertiary = md_theme_light_onTertiary_gray,
    tertiaryContainer = md_theme_light_tertiaryContainer_gray,
    onTertiaryContainer = md_theme_light_onTertiaryContainer_gray,
    error = md_theme_light_error_gray,
    errorContainer = md_theme_light_errorContainer_gray,
    onError = md_theme_light_onError_gray,
    onErrorContainer = md_theme_light_onErrorContainer_gray,
    background = md_theme_light_background_gray,
    onBackground = md_theme_light_onBackground_gray,
    surface = md_theme_light_surface_gray,
    onSurface = md_theme_light_onSurface_gray,
    surfaceVariant = md_theme_light_surfaceVariant_gray,
    onSurfaceVariant = md_theme_light_onSurfaceVariant_gray,
    outline = md_theme_light_outline_gray,
    inverseOnSurface = md_theme_light_inverseOnSurface_gray,
    inverseSurface = md_theme_light_inverseSurface_gray,
    inversePrimary = md_theme_light_inversePrimary_gray,
    surfaceTint = md_theme_light_surfaceTint_gray,
    outlineVariant = md_theme_light_outlineVariant_gray,
    scrim = md_theme_light_scrim_gray,
)


private val DarkColorsGray = darkColorScheme(
    primary = md_theme_dark_primary_gray,
    onPrimary = md_theme_dark_onPrimary_gray,
    primaryContainer = md_theme_dark_primaryContainer_gray,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer_gray,
    secondary = md_theme_dark_secondary_gray,
    onSecondary = md_theme_dark_onSecondary_gray,
    secondaryContainer = md_theme_dark_secondaryContainer_gray,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer_gray,
    tertiary = md_theme_dark_tertiary_gray,
    onTertiary = md_theme_dark_onTertiary_gray,
    tertiaryContainer = md_theme_dark_tertiaryContainer_gray,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer_gray,
    error = md_theme_dark_error_gray,
    errorContainer = md_theme_dark_errorContainer_gray,
    onError = md_theme_dark_onError_gray,
    onErrorContainer = md_theme_dark_onErrorContainer_gray,
    background = md_theme_dark_background_gray,
    onBackground = md_theme_dark_onBackground_gray,
    surface = md_theme_dark_surface_gray,
    onSurface = md_theme_dark_onSurface_gray,
    surfaceVariant = md_theme_dark_surfaceVariant_gray,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant_gray,
    outline = md_theme_dark_outline_gray,
    inverseOnSurface = md_theme_dark_inverseOnSurface_gray,
    inverseSurface = md_theme_dark_inverseSurface_gray,
    inversePrimary = md_theme_dark_inversePrimary_gray,
    surfaceTint = md_theme_dark_surfaceTint_gray,
    outlineVariant = md_theme_dark_outlineVariant_gray,
    scrim = md_theme_dark_scrim_gray,
)


private val LightColorsWhite = lightColorScheme(
    primary = md_theme_light_primary_white,
    onPrimary = md_theme_light_onPrimary_white,
    primaryContainer = md_theme_light_primaryContainer_white,
    onPrimaryContainer = md_theme_light_onPrimaryContainer_white,
    secondary = md_theme_light_secondary_white,
    onSecondary = md_theme_light_onSecondary_white,
    secondaryContainer = md_theme_light_secondaryContainer_white,
    onSecondaryContainer = md_theme_light_onSecondaryContainer_white,
    tertiary = md_theme_light_tertiary_white,
    onTertiary = md_theme_light_onTertiary_white,
    tertiaryContainer = md_theme_light_tertiaryContainer_white,
    onTertiaryContainer = md_theme_light_onTertiaryContainer_white,
    error = md_theme_light_error_white,
    errorContainer = md_theme_light_errorContainer_white,
    onError = md_theme_light_onError_white,
    onErrorContainer = md_theme_light_onErrorContainer_white,
    background = md_theme_light_background_white,
    onBackground = md_theme_light_onBackground_white,
    surface = md_theme_light_surface_white,
    onSurface = md_theme_light_onSurface_white,
    surfaceVariant = md_theme_light_surfaceVariant_white,
    onSurfaceVariant = md_theme_light_onSurfaceVariant_white,
    outline = md_theme_light_outline_white,
    inverseOnSurface = md_theme_light_inverseOnSurface_white,
    inverseSurface = md_theme_light_inverseSurface_white,
    inversePrimary = md_theme_light_inversePrimary_white,
    surfaceTint = md_theme_light_surfaceTint_white,
    outlineVariant = md_theme_light_outlineVariant_white,
    scrim = md_theme_light_scrim_white,
)


private val DarkColorsWhite = darkColorScheme(
    primary = md_theme_dark_primary_white,
    onPrimary = md_theme_dark_onPrimary_white,
    primaryContainer = md_theme_dark_primaryContainer_white,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer_white,
    secondary = md_theme_dark_secondary_white,
    onSecondary = md_theme_dark_onSecondary_white,
    secondaryContainer = md_theme_dark_secondaryContainer_white,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer_white,
    tertiary = md_theme_dark_tertiary_white,
    onTertiary = md_theme_dark_onTertiary_white,
    tertiaryContainer = md_theme_dark_tertiaryContainer_white,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer_white,
    error = md_theme_dark_error_white,
    errorContainer = md_theme_dark_errorContainer_white,
    onError = md_theme_dark_onError_white,
    onErrorContainer = md_theme_dark_onErrorContainer_white,
    background = md_theme_dark_background_white,
    onBackground = md_theme_dark_onBackground_white,
    surface = md_theme_dark_surface_white,
    onSurface = md_theme_dark_onSurface_white,
    surfaceVariant = md_theme_dark_surfaceVariant_white,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant_white,
    outline = md_theme_dark_outline_white,
    inverseOnSurface = md_theme_dark_inverseOnSurface_white,
    inverseSurface = md_theme_dark_inverseSurface_white,
    inversePrimary = md_theme_dark_inversePrimary_white,
    surfaceTint = md_theme_dark_surfaceTint_white,
    outlineVariant = md_theme_dark_outlineVariant_white,
    scrim = md_theme_dark_scrim_white,
)


private val LightColorsMaroon = lightColorScheme(
    primary = md_theme_light_primary_maroon,
    onPrimary = md_theme_light_onPrimary_maroon,
    primaryContainer = md_theme_light_primaryContainer_maroon,
    onPrimaryContainer = md_theme_light_onPrimaryContainer_maroon,
    secondary = md_theme_light_secondary_maroon,
    onSecondary = md_theme_light_onSecondary_maroon,
    secondaryContainer = md_theme_light_secondaryContainer_maroon,
    onSecondaryContainer = md_theme_light_onSecondaryContainer_maroon,
    tertiary = md_theme_light_tertiary_maroon,
    onTertiary = md_theme_light_onTertiary_maroon,
    tertiaryContainer = md_theme_light_tertiaryContainer_maroon,
    onTertiaryContainer = md_theme_light_onTertiaryContainer_maroon,
    error = md_theme_light_error_maroon,
    errorContainer = md_theme_light_errorContainer_maroon,
    onError = md_theme_light_onError_maroon,
    onErrorContainer = md_theme_light_onErrorContainer_maroon,
    background = md_theme_light_background_maroon,
    onBackground = md_theme_light_onBackground_maroon,
    surface = md_theme_light_surface_maroon,
    onSurface = md_theme_light_onSurface_maroon,
    surfaceVariant = md_theme_light_surfaceVariant_maroon,
    onSurfaceVariant = md_theme_light_onSurfaceVariant_maroon,
    outline = md_theme_light_outline_maroon,
    inverseOnSurface = md_theme_light_inverseOnSurface_maroon,
    inverseSurface = md_theme_light_inverseSurface_maroon,
    inversePrimary = md_theme_light_inversePrimary_maroon,
    surfaceTint = md_theme_light_surfaceTint_maroon,
    outlineVariant = md_theme_light_outlineVariant_maroon,
    scrim = md_theme_light_scrim_maroon,
)


private val DarkColorsMaroon = darkColorScheme(
    primary = md_theme_dark_primary_maroon,
    onPrimary = md_theme_dark_onPrimary_maroon,
    primaryContainer = md_theme_dark_primaryContainer_maroon,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer_maroon,
    secondary = md_theme_dark_secondary_maroon,
    onSecondary = md_theme_dark_onSecondary_maroon,
    secondaryContainer = md_theme_dark_secondaryContainer_maroon,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer_maroon,
    tertiary = md_theme_dark_tertiary_maroon,
    onTertiary = md_theme_dark_onTertiary_maroon,
    tertiaryContainer = md_theme_dark_tertiaryContainer_maroon,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer_maroon,
    error = md_theme_dark_error_maroon,
    errorContainer = md_theme_dark_errorContainer_maroon,
    onError = md_theme_dark_onError_maroon,
    onErrorContainer = md_theme_dark_onErrorContainer_maroon,
    background = md_theme_dark_background_maroon,
    onBackground = md_theme_dark_onBackground_maroon,
    surface = md_theme_dark_surface_maroon,
    onSurface = md_theme_dark_onSurface_maroon,
    surfaceVariant = md_theme_dark_surfaceVariant_maroon,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant_maroon,
    outline = md_theme_dark_outline_maroon,
    inverseOnSurface = md_theme_dark_inverseOnSurface_maroon,
    inverseSurface = md_theme_dark_inverseSurface_maroon,
    inversePrimary = md_theme_dark_inversePrimary_maroon,
    surfaceTint = md_theme_dark_surfaceTint_maroon,
    outlineVariant = md_theme_dark_outlineVariant_maroon,
    scrim = md_theme_dark_scrim_maroon,
)


private val LightColorsRed = lightColorScheme(
    primary = md_theme_light_primary_red,
    onPrimary = md_theme_light_onPrimary_red,
    primaryContainer = md_theme_light_primaryContainer_red,
    onPrimaryContainer = md_theme_light_onPrimaryContainer_red,
    secondary = md_theme_light_secondary_red,
    onSecondary = md_theme_light_onSecondary_red,
    secondaryContainer = md_theme_light_secondaryContainer_red,
    onSecondaryContainer = md_theme_light_onSecondaryContainer_red,
    tertiary = md_theme_light_tertiary_red,
    onTertiary = md_theme_light_onTertiary_red,
    tertiaryContainer = md_theme_light_tertiaryContainer_red,
    onTertiaryContainer = md_theme_light_onTertiaryContainer_red,
    error = md_theme_light_error_red,
    errorContainer = md_theme_light_errorContainer_red,
    onError = md_theme_light_onError_red,
    onErrorContainer = md_theme_light_onErrorContainer_red,
    background = md_theme_light_background_red,
    onBackground = md_theme_light_onBackground_red,
    surface = md_theme_light_surface_red,
    onSurface = md_theme_light_onSurface_red,
    surfaceVariant = md_theme_light_surfaceVariant_red,
    onSurfaceVariant = md_theme_light_onSurfaceVariant_red,
    outline = md_theme_light_outline_red,
    inverseOnSurface = md_theme_light_inverseOnSurface_red,
    inverseSurface = md_theme_light_inverseSurface_red,
    inversePrimary = md_theme_light_inversePrimary_red,
    surfaceTint = md_theme_light_surfaceTint_red,
    outlineVariant = md_theme_light_outlineVariant_red,
    scrim = md_theme_light_scrim_red,
)


private val DarkColorsRed = darkColorScheme(
    primary = md_theme_dark_primary_red,
    onPrimary = md_theme_dark_onPrimary_red,
    primaryContainer = md_theme_dark_primaryContainer_red,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer_red,
    secondary = md_theme_dark_secondary_red,
    onSecondary = md_theme_dark_onSecondary_red,
    secondaryContainer = md_theme_dark_secondaryContainer_red,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer_red,
    tertiary = md_theme_dark_tertiary_red,
    onTertiary = md_theme_dark_onTertiary_red,
    tertiaryContainer = md_theme_dark_tertiaryContainer_red,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer_red,
    error = md_theme_dark_error_red,
    errorContainer = md_theme_dark_errorContainer_red,
    onError = md_theme_dark_onError_red,
    onErrorContainer = md_theme_dark_onErrorContainer_red,
    background = md_theme_dark_background_red,
    onBackground = md_theme_dark_onBackground_red,
    surface = md_theme_dark_surface_red,
    onSurface = md_theme_dark_onSurface_red,
    surfaceVariant = md_theme_dark_surfaceVariant_red,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant_red,
    outline = md_theme_dark_outline_red,
    inverseOnSurface = md_theme_dark_inverseOnSurface_red,
    inverseSurface = md_theme_dark_inverseSurface_red,
    inversePrimary = md_theme_dark_inversePrimary_red,
    surfaceTint = md_theme_dark_surfaceTint_red,
    outlineVariant = md_theme_dark_outlineVariant_red,
    scrim = md_theme_dark_scrim_red,
)


private val LightColorsPurple = lightColorScheme(
    primary = md_theme_light_primary_purple,
    onPrimary = md_theme_light_onPrimary_purple,
    primaryContainer = md_theme_light_primaryContainer_purple,
    onPrimaryContainer = md_theme_light_onPrimaryContainer_purple,
    secondary = md_theme_light_secondary_purple,
    onSecondary = md_theme_light_onSecondary_purple,
    secondaryContainer = md_theme_light_secondaryContainer_purple,
    onSecondaryContainer = md_theme_light_onSecondaryContainer_purple,
    tertiary = md_theme_light_tertiary_purple,
    onTertiary = md_theme_light_onTertiary_purple,
    tertiaryContainer = md_theme_light_tertiaryContainer_purple,
    onTertiaryContainer = md_theme_light_onTertiaryContainer_purple,
    error = md_theme_light_error_purple,
    errorContainer = md_theme_light_errorContainer_purple,
    onError = md_theme_light_onError_purple,
    onErrorContainer = md_theme_light_onErrorContainer_purple,
    background = md_theme_light_background_purple,
    onBackground = md_theme_light_onBackground_purple,
    surface = md_theme_light_surface_purple,
    onSurface = md_theme_light_onSurface_purple,
    surfaceVariant = md_theme_light_surfaceVariant_purple,
    onSurfaceVariant = md_theme_light_onSurfaceVariant_purple,
    outline = md_theme_light_outline_purple,
    inverseOnSurface = md_theme_light_inverseOnSurface_purple,
    inverseSurface = md_theme_light_inverseSurface_purple,
    inversePrimary = md_theme_light_inversePrimary_purple,
    surfaceTint = md_theme_light_surfaceTint_purple,
    outlineVariant = md_theme_light_outlineVariant_purple,
    scrim = md_theme_light_scrim_purple,
)


private val DarkColorsPurple = darkColorScheme(
    primary = md_theme_dark_primary_purple,
    onPrimary = md_theme_dark_onPrimary_purple,
    primaryContainer = md_theme_dark_primaryContainer_purple,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer_purple,
    secondary = md_theme_dark_secondary_purple,
    onSecondary = md_theme_dark_onSecondary_purple,
    secondaryContainer = md_theme_dark_secondaryContainer_purple,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer_purple,
    tertiary = md_theme_dark_tertiary_purple,
    onTertiary = md_theme_dark_onTertiary_purple,
    tertiaryContainer = md_theme_dark_tertiaryContainer_purple,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer_purple,
    error = md_theme_dark_error_purple,
    errorContainer = md_theme_dark_errorContainer_purple,
    onError = md_theme_dark_onError_purple,
    onErrorContainer = md_theme_dark_onErrorContainer_purple,
    background = md_theme_dark_background_purple,
    onBackground = md_theme_dark_onBackground_purple,
    surface = md_theme_dark_surface_purple,
    onSurface = md_theme_dark_onSurface_purple,
    surfaceVariant = md_theme_dark_surfaceVariant_purple,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant_purple,
    outline = md_theme_dark_outline_purple,
    inverseOnSurface = md_theme_dark_inverseOnSurface_purple,
    inverseSurface = md_theme_dark_inverseSurface_purple,
    inversePrimary = md_theme_dark_inversePrimary_purple,
    surfaceTint = md_theme_dark_surfaceTint_purple,
    outlineVariant = md_theme_dark_outlineVariant_purple,
    scrim = md_theme_dark_scrim_purple,
)


private val LightColorsFuchsia = lightColorScheme(
    primary = md_theme_light_primary_fuchsia,
    onPrimary = md_theme_light_onPrimary_fuchsia,
    primaryContainer = md_theme_light_primaryContainer_fuchsia,
    onPrimaryContainer = md_theme_light_onPrimaryContainer_fuchsia,
    secondary = md_theme_light_secondary_fuchsia,
    onSecondary = md_theme_light_onSecondary_fuchsia,
    secondaryContainer = md_theme_light_secondaryContainer_fuchsia,
    onSecondaryContainer = md_theme_light_onSecondaryContainer_fuchsia,
    tertiary = md_theme_light_tertiary_fuchsia,
    onTertiary = md_theme_light_onTertiary_fuchsia,
    tertiaryContainer = md_theme_light_tertiaryContainer_fuchsia,
    onTertiaryContainer = md_theme_light_onTertiaryContainer_fuchsia,
    error = md_theme_light_error_fuchsia,
    errorContainer = md_theme_light_errorContainer_fuchsia,
    onError = md_theme_light_onError_fuchsia,
    onErrorContainer = md_theme_light_onErrorContainer_fuchsia,
    background = md_theme_light_background_fuchsia,
    onBackground = md_theme_light_onBackground_fuchsia,
    surface = md_theme_light_surface_fuchsia,
    onSurface = md_theme_light_onSurface_fuchsia,
    surfaceVariant = md_theme_light_surfaceVariant_fuchsia,
    onSurfaceVariant = md_theme_light_onSurfaceVariant_fuchsia,
    outline = md_theme_light_outline_fuchsia,
    inverseOnSurface = md_theme_light_inverseOnSurface_fuchsia,
    inverseSurface = md_theme_light_inverseSurface_fuchsia,
    inversePrimary = md_theme_light_inversePrimary_fuchsia,
    surfaceTint = md_theme_light_surfaceTint_fuchsia,
    outlineVariant = md_theme_light_outlineVariant_fuchsia,
    scrim = md_theme_light_scrim_fuchsia,
)


private val DarkColorsFuchsia = darkColorScheme(
    primary = md_theme_dark_primary_fuchsia,
    onPrimary = md_theme_dark_onPrimary_fuchsia,
    primaryContainer = md_theme_dark_primaryContainer_fuchsia,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer_fuchsia,
    secondary = md_theme_dark_secondary_fuchsia,
    onSecondary = md_theme_dark_onSecondary_fuchsia,
    secondaryContainer = md_theme_dark_secondaryContainer_fuchsia,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer_fuchsia,
    tertiary = md_theme_dark_tertiary_fuchsia,
    onTertiary = md_theme_dark_onTertiary_fuchsia,
    tertiaryContainer = md_theme_dark_tertiaryContainer_fuchsia,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer_fuchsia,
    error = md_theme_dark_error_fuchsia,
    errorContainer = md_theme_dark_errorContainer_fuchsia,
    onError = md_theme_dark_onError_fuchsia,
    onErrorContainer = md_theme_dark_onErrorContainer_fuchsia,
    background = md_theme_dark_background_fuchsia,
    onBackground = md_theme_dark_onBackground_fuchsia,
    surface = md_theme_dark_surface_fuchsia,
    onSurface = md_theme_dark_onSurface_fuchsia,
    surfaceVariant = md_theme_dark_surfaceVariant_fuchsia,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant_fuchsia,
    outline = md_theme_dark_outline_fuchsia,
    inverseOnSurface = md_theme_dark_inverseOnSurface_fuchsia,
    inverseSurface = md_theme_dark_inverseSurface_fuchsia,
    inversePrimary = md_theme_dark_inversePrimary_fuchsia,
    surfaceTint = md_theme_dark_surfaceTint_fuchsia,
    outlineVariant = md_theme_dark_outlineVariant_fuchsia,
    scrim = md_theme_dark_scrim_fuchsia,
)

private val LightColorsGreen = lightColorScheme(
    primary = md_theme_light_primary_green,
    onPrimary = md_theme_light_onPrimary_green,
    primaryContainer = md_theme_light_primaryContainer_green,
    onPrimaryContainer = md_theme_light_onPrimaryContainer_green,
    secondary = md_theme_light_secondary_green,
    onSecondary = md_theme_light_onSecondary_green,
    secondaryContainer = md_theme_light_secondaryContainer_green,
    onSecondaryContainer = md_theme_light_onSecondaryContainer_green,
    tertiary = md_theme_light_tertiary_green,
    onTertiary = md_theme_light_onTertiary_green,
    tertiaryContainer = md_theme_light_tertiaryContainer_green,
    onTertiaryContainer = md_theme_light_onTertiaryContainer_green,
    error = md_theme_light_error_green,
    errorContainer = md_theme_light_errorContainer_green,
    onError = md_theme_light_onError_green,
    onErrorContainer = md_theme_light_onErrorContainer_green,
    background = md_theme_light_background_green,
    onBackground = md_theme_light_onBackground_green,
    surface = md_theme_light_surface_green,
    onSurface = md_theme_light_onSurface_green,
    surfaceVariant = md_theme_light_surfaceVariant_green,
    onSurfaceVariant = md_theme_light_onSurfaceVariant_green,
    outline = md_theme_light_outline_green,
    inverseOnSurface = md_theme_light_inverseOnSurface_green,
    inverseSurface = md_theme_light_inverseSurface_green,
    inversePrimary = md_theme_light_inversePrimary_green,
    surfaceTint = md_theme_light_surfaceTint_green,
    outlineVariant = md_theme_light_outlineVariant_green,
    scrim = md_theme_light_scrim_green,
)


private val DarkColorsGreen = darkColorScheme(
    primary = md_theme_dark_primary_green,
    onPrimary = md_theme_dark_onPrimary_green,
    primaryContainer = md_theme_dark_primaryContainer_green,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer_green,
    secondary = md_theme_dark_secondary_green,
    onSecondary = md_theme_dark_onSecondary_green,
    secondaryContainer = md_theme_dark_secondaryContainer_green,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer_green,
    tertiary = md_theme_dark_tertiary_green,
    onTertiary = md_theme_dark_onTertiary_green,
    tertiaryContainer = md_theme_dark_tertiaryContainer_green,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer_green,
    error = md_theme_dark_error_green,
    errorContainer = md_theme_dark_errorContainer_green,
    onError = md_theme_dark_onError_green,
    onErrorContainer = md_theme_dark_onErrorContainer_green,
    background = md_theme_dark_background_green,
    onBackground = md_theme_dark_onBackground_green,
    surface = md_theme_dark_surface_green,
    onSurface = md_theme_dark_onSurface_green,
    surfaceVariant = md_theme_dark_surfaceVariant_green,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant_green,
    outline = md_theme_dark_outline_green,
    inverseOnSurface = md_theme_dark_inverseOnSurface_green,
    inverseSurface = md_theme_dark_inverseSurface_green,
    inversePrimary = md_theme_dark_inversePrimary_green,
    surfaceTint = md_theme_dark_surfaceTint_green,
    outlineVariant = md_theme_dark_outlineVariant_green,
    scrim = md_theme_dark_scrim_green,
)


private val LightColorsLime = lightColorScheme(
    primary = md_theme_light_primary_lime,
    onPrimary = md_theme_light_onPrimary_lime,
    primaryContainer = md_theme_light_primaryContainer_lime,
    onPrimaryContainer = md_theme_light_onPrimaryContainer_lime,
    secondary = md_theme_light_secondary_lime,
    onSecondary = md_theme_light_onSecondary_lime,
    secondaryContainer = md_theme_light_secondaryContainer_lime,
    onSecondaryContainer = md_theme_light_onSecondaryContainer_lime,
    tertiary = md_theme_light_tertiary_lime,
    onTertiary = md_theme_light_onTertiary_lime,
    tertiaryContainer = md_theme_light_tertiaryContainer_lime,
    onTertiaryContainer = md_theme_light_onTertiaryContainer_lime,
    error = md_theme_light_error_lime,
    errorContainer = md_theme_light_errorContainer_lime,
    onError = md_theme_light_onError_lime,
    onErrorContainer = md_theme_light_onErrorContainer_lime,
    background = md_theme_light_background_lime,
    onBackground = md_theme_light_onBackground_lime,
    surface = md_theme_light_surface_lime,
    onSurface = md_theme_light_onSurface_lime,
    surfaceVariant = md_theme_light_surfaceVariant_lime,
    onSurfaceVariant = md_theme_light_onSurfaceVariant_lime,
    outline = md_theme_light_outline_lime,
    inverseOnSurface = md_theme_light_inverseOnSurface_lime,
    inverseSurface = md_theme_light_inverseSurface_lime,
    inversePrimary = md_theme_light_inversePrimary_lime,
    surfaceTint = md_theme_light_surfaceTint_lime,
    outlineVariant = md_theme_light_outlineVariant_lime,
    scrim = md_theme_light_scrim_lime,
)


private val DarkColorsLime = darkColorScheme(
    primary = md_theme_dark_primary_lime,
    onPrimary = md_theme_dark_onPrimary_lime,
    primaryContainer = md_theme_dark_primaryContainer_lime,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer_lime,
    secondary = md_theme_dark_secondary_lime,
    onSecondary = md_theme_dark_onSecondary_lime,
    secondaryContainer = md_theme_dark_secondaryContainer_lime,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer_lime,
    tertiary = md_theme_dark_tertiary_lime,
    onTertiary = md_theme_dark_onTertiary_lime,
    tertiaryContainer = md_theme_dark_tertiaryContainer_lime,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer_lime,
    error = md_theme_dark_error_lime,
    errorContainer = md_theme_dark_errorContainer_lime,
    onError = md_theme_dark_onError_lime,
    onErrorContainer = md_theme_dark_onErrorContainer_lime,
    background = md_theme_dark_background_lime,
    onBackground = md_theme_dark_onBackground_lime,
    surface = md_theme_dark_surface_lime,
    onSurface = md_theme_dark_onSurface_lime,
    surfaceVariant = md_theme_dark_surfaceVariant_lime,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant_lime,
    outline = md_theme_dark_outline_lime,
    inverseOnSurface = md_theme_dark_inverseOnSurface_lime,
    inverseSurface = md_theme_dark_inverseSurface_lime,
    inversePrimary = md_theme_dark_inversePrimary_lime,
    surfaceTint = md_theme_dark_surfaceTint_lime,
    outlineVariant = md_theme_dark_outlineVariant_lime,
    scrim = md_theme_dark_scrim_lime,
)

private val LightColorsOlive = lightColorScheme(
    primary = md_theme_light_primary_olive,
    onPrimary = md_theme_light_onPrimary_olive,
    primaryContainer = md_theme_light_primaryContainer_olive,
    onPrimaryContainer = md_theme_light_onPrimaryContainer_olive,
    secondary = md_theme_light_secondary_olive,
    onSecondary = md_theme_light_onSecondary_olive,
    secondaryContainer = md_theme_light_secondaryContainer_olive,
    onSecondaryContainer = md_theme_light_onSecondaryContainer_olive,
    tertiary = md_theme_light_tertiary_olive,
    onTertiary = md_theme_light_onTertiary_olive,
    tertiaryContainer = md_theme_light_tertiaryContainer_olive,
    onTertiaryContainer = md_theme_light_onTertiaryContainer_olive,
    error = md_theme_light_error_olive,
    errorContainer = md_theme_light_errorContainer_olive,
    onError = md_theme_light_onError_olive,
    onErrorContainer = md_theme_light_onErrorContainer_olive,
    background = md_theme_light_background_olive,
    onBackground = md_theme_light_onBackground_olive,
    surface = md_theme_light_surface_olive,
    onSurface = md_theme_light_onSurface_olive,
    surfaceVariant = md_theme_light_surfaceVariant_olive,
    onSurfaceVariant = md_theme_light_onSurfaceVariant_olive,
    outline = md_theme_light_outline_olive,
    inverseOnSurface = md_theme_light_inverseOnSurface_olive,
    inverseSurface = md_theme_light_inverseSurface_olive,
    inversePrimary = md_theme_light_inversePrimary_olive,
    surfaceTint = md_theme_light_surfaceTint_olive,
    outlineVariant = md_theme_light_outlineVariant_olive,
    scrim = md_theme_light_scrim_olive,
)


private val DarkColorsOlive = darkColorScheme(
    primary = md_theme_dark_primary_olive,
    onPrimary = md_theme_dark_onPrimary_olive,
    primaryContainer = md_theme_dark_primaryContainer_olive,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer_olive,
    secondary = md_theme_dark_secondary_olive,
    onSecondary = md_theme_dark_onSecondary_olive,
    secondaryContainer = md_theme_dark_secondaryContainer_olive,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer_olive,
    tertiary = md_theme_dark_tertiary_olive,
    onTertiary = md_theme_dark_onTertiary_olive,
    tertiaryContainer = md_theme_dark_tertiaryContainer_olive,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer_olive,
    error = md_theme_dark_error_olive,
    errorContainer = md_theme_dark_errorContainer_olive,
    onError = md_theme_dark_onError_olive,
    onErrorContainer = md_theme_dark_onErrorContainer_olive,
    background = md_theme_dark_background_olive,
    onBackground = md_theme_dark_onBackground_olive,
    surface = md_theme_dark_surface_olive,
    onSurface = md_theme_dark_onSurface_olive,
    surfaceVariant = md_theme_dark_surfaceVariant_olive,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant_olive,
    outline = md_theme_dark_outline_olive,
    inverseOnSurface = md_theme_dark_inverseOnSurface_olive,
    inverseSurface = md_theme_dark_inverseSurface_olive,
    inversePrimary = md_theme_dark_inversePrimary_olive,
    surfaceTint = md_theme_dark_surfaceTint_olive,
    outlineVariant = md_theme_dark_outlineVariant_olive,
    scrim = md_theme_dark_scrim_olive,
)


private val LightColorsYellow = lightColorScheme(
    primary = md_theme_light_primary_yellow,
    onPrimary = md_theme_light_onPrimary_yellow,
    primaryContainer = md_theme_light_primaryContainer_yellow,
    onPrimaryContainer = md_theme_light_onPrimaryContainer_yellow,
    secondary = md_theme_light_secondary_yellow,
    onSecondary = md_theme_light_onSecondary_yellow,
    secondaryContainer = md_theme_light_secondaryContainer_yellow,
    onSecondaryContainer = md_theme_light_onSecondaryContainer_yellow,
    tertiary = md_theme_light_tertiary_yellow,
    onTertiary = md_theme_light_onTertiary_yellow,
    tertiaryContainer = md_theme_light_tertiaryContainer_yellow,
    onTertiaryContainer = md_theme_light_onTertiaryContainer_yellow,
    error = md_theme_light_error_yellow,
    errorContainer = md_theme_light_errorContainer_yellow,
    onError = md_theme_light_onError_yellow,
    onErrorContainer = md_theme_light_onErrorContainer_yellow,
    background = md_theme_light_background_yellow,
    onBackground = md_theme_light_onBackground_yellow,
    surface = md_theme_light_surface_yellow,
    onSurface = md_theme_light_onSurface_yellow,
    surfaceVariant = md_theme_light_surfaceVariant_yellow,
    onSurfaceVariant = md_theme_light_onSurfaceVariant_yellow,
    outline = md_theme_light_outline_yellow,
    inverseOnSurface = md_theme_light_inverseOnSurface_yellow,
    inverseSurface = md_theme_light_inverseSurface_yellow,
    inversePrimary = md_theme_light_inversePrimary_yellow,
    surfaceTint = md_theme_light_surfaceTint_yellow,
    outlineVariant = md_theme_light_outlineVariant_yellow,
    scrim = md_theme_light_scrim_yellow,
)


private val DarkColorsYellow = darkColorScheme(
    primary = md_theme_dark_primary_yellow,
    onPrimary = md_theme_dark_onPrimary_yellow,
    primaryContainer = md_theme_dark_primaryContainer_yellow,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer_yellow,
    secondary = md_theme_dark_secondary_yellow,
    onSecondary = md_theme_dark_onSecondary_yellow,
    secondaryContainer = md_theme_dark_secondaryContainer_yellow,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer_yellow,
    tertiary = md_theme_dark_tertiary_yellow,
    onTertiary = md_theme_dark_onTertiary_yellow,
    tertiaryContainer = md_theme_dark_tertiaryContainer_yellow,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer_yellow,
    error = md_theme_dark_error_yellow,
    errorContainer = md_theme_dark_errorContainer_yellow,
    onError = md_theme_dark_onError_yellow,
    onErrorContainer = md_theme_dark_onErrorContainer_yellow,
    background = md_theme_dark_background_yellow,
    onBackground = md_theme_dark_onBackground_yellow,
    surface = md_theme_dark_surface_yellow,
    onSurface = md_theme_dark_onSurface_yellow,
    surfaceVariant = md_theme_dark_surfaceVariant_yellow,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant_yellow,
    outline = md_theme_dark_outline_yellow,
    inverseOnSurface = md_theme_dark_inverseOnSurface_yellow,
    inverseSurface = md_theme_dark_inverseSurface_yellow,
    inversePrimary = md_theme_dark_inversePrimary_yellow,
    surfaceTint = md_theme_dark_surfaceTint_yellow,
    outlineVariant = md_theme_dark_outlineVariant_yellow,
    scrim = md_theme_dark_scrim_yellow,
)


private val LightColorsNavy = lightColorScheme(
    primary = md_theme_light_primary_navy,
    onPrimary = md_theme_light_onPrimary_navy,
    primaryContainer = md_theme_light_primaryContainer_navy,
    onPrimaryContainer = md_theme_light_onPrimaryContainer_navy,
    secondary = md_theme_light_secondary_navy,
    onSecondary = md_theme_light_onSecondary_navy,
    secondaryContainer = md_theme_light_secondaryContainer_navy,
    onSecondaryContainer = md_theme_light_onSecondaryContainer_navy,
    tertiary = md_theme_light_tertiary_navy,
    onTertiary = md_theme_light_onTertiary_navy,
    tertiaryContainer = md_theme_light_tertiaryContainer_navy,
    onTertiaryContainer = md_theme_light_onTertiaryContainer_navy,
    error = md_theme_light_error_navy,
    errorContainer = md_theme_light_errorContainer_navy,
    onError = md_theme_light_onError_navy,
    onErrorContainer = md_theme_light_onErrorContainer_navy,
    background = md_theme_light_background_navy,
    onBackground = md_theme_light_onBackground_navy,
    surface = md_theme_light_surface_navy,
    onSurface = md_theme_light_onSurface_navy,
    surfaceVariant = md_theme_light_surfaceVariant_navy,
    onSurfaceVariant = md_theme_light_onSurfaceVariant_navy,
    outline = md_theme_light_outline_navy,
    inverseOnSurface = md_theme_light_inverseOnSurface_navy,
    inverseSurface = md_theme_light_inverseSurface_navy,
    inversePrimary = md_theme_light_inversePrimary_navy,
    surfaceTint = md_theme_light_surfaceTint_navy,
    outlineVariant = md_theme_light_outlineVariant_navy,
    scrim = md_theme_light_scrim_navy,
)


private val DarkColorsNavy = darkColorScheme(
    primary = md_theme_dark_primary_navy,
    onPrimary = md_theme_dark_onPrimary_navy,
    primaryContainer = md_theme_dark_primaryContainer_navy,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer_navy,
    secondary = md_theme_dark_secondary_navy,
    onSecondary = md_theme_dark_onSecondary_navy,
    secondaryContainer = md_theme_dark_secondaryContainer_navy,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer_navy,
    tertiary = md_theme_dark_tertiary_navy,
    onTertiary = md_theme_dark_onTertiary_navy,
    tertiaryContainer = md_theme_dark_tertiaryContainer_navy,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer_navy,
    error = md_theme_dark_error_navy,
    errorContainer = md_theme_dark_errorContainer_navy,
    onError = md_theme_dark_onError_navy,
    onErrorContainer = md_theme_dark_onErrorContainer_navy,
    background = md_theme_dark_background_navy,
    onBackground = md_theme_dark_onBackground_navy,
    surface = md_theme_dark_surface_navy,
    onSurface = md_theme_dark_onSurface_navy,
    surfaceVariant = md_theme_dark_surfaceVariant_navy,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant_navy,
    outline = md_theme_dark_outline_navy,
    inverseOnSurface = md_theme_dark_inverseOnSurface_navy,
    inverseSurface = md_theme_dark_inverseSurface_navy,
    inversePrimary = md_theme_dark_inversePrimary_navy,
    surfaceTint = md_theme_dark_surfaceTint_navy,
    outlineVariant = md_theme_dark_outlineVariant_navy,
    scrim = md_theme_dark_scrim_navy,
)


private val LightColorsTeal = lightColorScheme(
    primary = md_theme_light_primary_teal,
    onPrimary = md_theme_light_onPrimary_teal,
    primaryContainer = md_theme_light_primaryContainer_teal,
    onPrimaryContainer = md_theme_light_onPrimaryContainer_teal,
    secondary = md_theme_light_secondary_teal,
    onSecondary = md_theme_light_onSecondary_teal,
    secondaryContainer = md_theme_light_secondaryContainer_teal,
    onSecondaryContainer = md_theme_light_onSecondaryContainer_teal,
    tertiary = md_theme_light_tertiary_teal,
    onTertiary = md_theme_light_onTertiary_teal,
    tertiaryContainer = md_theme_light_tertiaryContainer_teal,
    onTertiaryContainer = md_theme_light_onTertiaryContainer_teal,
    error = md_theme_light_error_teal,
    errorContainer = md_theme_light_errorContainer_teal,
    onError = md_theme_light_onError_teal,
    onErrorContainer = md_theme_light_onErrorContainer_teal,
    background = md_theme_light_background_teal,
    onBackground = md_theme_light_onBackground_teal,
    surface = md_theme_light_surface_teal,
    onSurface = md_theme_light_onSurface_teal,
    surfaceVariant = md_theme_light_surfaceVariant_teal,
    onSurfaceVariant = md_theme_light_onSurfaceVariant_teal,
    outline = md_theme_light_outline_teal,
    inverseOnSurface = md_theme_light_inverseOnSurface_teal,
    inverseSurface = md_theme_light_inverseSurface_teal,
    inversePrimary = md_theme_light_inversePrimary_teal,
    surfaceTint = md_theme_light_surfaceTint_teal,
    outlineVariant = md_theme_light_outlineVariant_teal,
    scrim = md_theme_light_scrim_teal,
)


private val DarkColorsTeal = darkColorScheme(
    primary = md_theme_dark_primary_teal,
    onPrimary = md_theme_dark_onPrimary_teal,
    primaryContainer = md_theme_dark_primaryContainer_teal,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer_teal,
    secondary = md_theme_dark_secondary_teal,
    onSecondary = md_theme_dark_onSecondary_teal,
    secondaryContainer = md_theme_dark_secondaryContainer_teal,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer_teal,
    tertiary = md_theme_dark_tertiary_teal,
    onTertiary = md_theme_dark_onTertiary_teal,
    tertiaryContainer = md_theme_dark_tertiaryContainer_teal,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer_teal,
    error = md_theme_dark_error_teal,
    errorContainer = md_theme_dark_errorContainer_teal,
    onError = md_theme_dark_onError_teal,
    onErrorContainer = md_theme_dark_onErrorContainer_teal,
    background = md_theme_dark_background_teal,
    onBackground = md_theme_dark_onBackground_teal,
    surface = md_theme_dark_surface_teal,
    onSurface = md_theme_dark_onSurface_teal,
    surfaceVariant = md_theme_dark_surfaceVariant_teal,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant_teal,
    outline = md_theme_dark_outline_teal,
    inverseOnSurface = md_theme_dark_inverseOnSurface_teal,
    inverseSurface = md_theme_dark_inverseSurface_teal,
    inversePrimary = md_theme_dark_inversePrimary_teal,
    surfaceTint = md_theme_dark_surfaceTint_teal,
    outlineVariant = md_theme_dark_outlineVariant_teal,
    scrim = md_theme_dark_scrim_teal,
)


private val LightColorsBlue = lightColorScheme(
    primary = md_theme_light_primary_blue,
    onPrimary = md_theme_light_onPrimary_blue,
    primaryContainer = md_theme_light_primaryContainer_blue,
    onPrimaryContainer = md_theme_light_onPrimaryContainer_blue,
    secondary = md_theme_light_secondary_blue,
    onSecondary = md_theme_light_onSecondary_blue,
    secondaryContainer = md_theme_light_secondaryContainer_blue,
    onSecondaryContainer = md_theme_light_onSecondaryContainer_blue,
    tertiary = md_theme_light_tertiary_blue,
    onTertiary = md_theme_light_onTertiary_blue,
    tertiaryContainer = md_theme_light_tertiaryContainer_blue,
    onTertiaryContainer = md_theme_light_onTertiaryContainer_blue,
    error = md_theme_light_error_blue,
    errorContainer = md_theme_light_errorContainer_blue,
    onError = md_theme_light_onError_blue,
    onErrorContainer = md_theme_light_onErrorContainer_blue,
    background = md_theme_light_background_blue,
    onBackground = md_theme_light_onBackground_blue,
    surface = md_theme_light_surface_blue,
    onSurface = md_theme_light_onSurface_blue,
    surfaceVariant = md_theme_light_surfaceVariant_blue,
    onSurfaceVariant = md_theme_light_onSurfaceVariant_blue,
    outline = md_theme_light_outline_blue,
    inverseOnSurface = md_theme_light_inverseOnSurface_blue,
    inverseSurface = md_theme_light_inverseSurface_blue,
    inversePrimary = md_theme_light_inversePrimary_blue,
    surfaceTint = md_theme_light_surfaceTint_blue,
    outlineVariant = md_theme_light_outlineVariant_blue,
    scrim = md_theme_light_scrim_blue,
)


private val DarkColorsBlue = darkColorScheme(
    primary = md_theme_dark_primary_blue,
    onPrimary = md_theme_dark_onPrimary_blue,
    primaryContainer = md_theme_dark_primaryContainer_blue,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer_blue,
    secondary = md_theme_dark_secondary_blue,
    onSecondary = md_theme_dark_onSecondary_blue,
    secondaryContainer = md_theme_dark_secondaryContainer_blue,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer_blue,
    tertiary = md_theme_dark_tertiary_blue,
    onTertiary = md_theme_dark_onTertiary_blue,
    tertiaryContainer = md_theme_dark_tertiaryContainer_blue,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer_blue,
    error = md_theme_dark_error_blue,
    errorContainer = md_theme_dark_errorContainer_blue,
    onError = md_theme_dark_onError_blue,
    onErrorContainer = md_theme_dark_onErrorContainer_blue,
    background = md_theme_dark_background_blue,
    onBackground = md_theme_dark_onBackground_blue,
    surface = md_theme_dark_surface_blue,
    onSurface = md_theme_dark_onSurface_blue,
    surfaceVariant = md_theme_dark_surfaceVariant_blue,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant_blue,
    outline = md_theme_dark_outline_blue,
    inverseOnSurface = md_theme_dark_inverseOnSurface_blue,
    inverseSurface = md_theme_dark_inverseSurface_blue,
    inversePrimary = md_theme_dark_inversePrimary_blue,
    surfaceTint = md_theme_dark_surfaceTint_blue,
    outlineVariant = md_theme_dark_outlineVariant_blue,
    scrim = md_theme_dark_scrim_blue,
)


private val LightColorsAqua = lightColorScheme(
    primary = md_theme_light_primary_aqua,
    onPrimary = md_theme_light_onPrimary_aqua,
    primaryContainer = md_theme_light_primaryContainer_aqua,
    onPrimaryContainer = md_theme_light_onPrimaryContainer_aqua,
    secondary = md_theme_light_secondary_aqua,
    onSecondary = md_theme_light_onSecondary_aqua,
    secondaryContainer = md_theme_light_secondaryContainer_aqua,
    onSecondaryContainer = md_theme_light_onSecondaryContainer_aqua,
    tertiary = md_theme_light_tertiary_aqua,
    onTertiary = md_theme_light_onTertiary_aqua,
    tertiaryContainer = md_theme_light_tertiaryContainer_aqua,
    onTertiaryContainer = md_theme_light_onTertiaryContainer_aqua,
    error = md_theme_light_error_aqua,
    errorContainer = md_theme_light_errorContainer_aqua,
    onError = md_theme_light_onError_aqua,
    onErrorContainer = md_theme_light_onErrorContainer_aqua,
    background = md_theme_light_background_aqua,
    onBackground = md_theme_light_onBackground_aqua,
    surface = md_theme_light_surface_aqua,
    onSurface = md_theme_light_onSurface_aqua,
    surfaceVariant = md_theme_light_surfaceVariant_aqua,
    onSurfaceVariant = md_theme_light_onSurfaceVariant_aqua,
    outline = md_theme_light_outline_aqua,
    inverseOnSurface = md_theme_light_inverseOnSurface_aqua,
    inverseSurface = md_theme_light_inverseSurface_aqua,
    inversePrimary = md_theme_light_inversePrimary_aqua,
    surfaceTint = md_theme_light_surfaceTint_aqua,
    outlineVariant = md_theme_light_outlineVariant_aqua,
    scrim = md_theme_light_scrim_aqua,
)


private val DarkColorsAqua = darkColorScheme(
    primary = md_theme_dark_primary_aqua,
    onPrimary = md_theme_dark_onPrimary_aqua,
    primaryContainer = md_theme_dark_primaryContainer_aqua,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer_aqua,
    secondary = md_theme_dark_secondary_aqua,
    onSecondary = md_theme_dark_onSecondary_aqua,
    secondaryContainer = md_theme_dark_secondaryContainer_aqua,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer_aqua,
    tertiary = md_theme_dark_tertiary_aqua,
    onTertiary = md_theme_dark_onTertiary_aqua,
    tertiaryContainer = md_theme_dark_tertiaryContainer_aqua,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer_aqua,
    error = md_theme_dark_error_aqua,
    errorContainer = md_theme_dark_errorContainer_aqua,
    onError = md_theme_dark_onError_aqua,
    onErrorContainer = md_theme_dark_onErrorContainer_aqua,
    background = md_theme_dark_background_aqua,
    onBackground = md_theme_dark_onBackground_aqua,
    surface = md_theme_dark_surface_aqua,
    onSurface = md_theme_dark_onSurface_aqua,
    surfaceVariant = md_theme_dark_surfaceVariant_aqua,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant_aqua,
    outline = md_theme_dark_outline_aqua,
    inverseOnSurface = md_theme_dark_inverseOnSurface_aqua,
    inverseSurface = md_theme_dark_inverseSurface_aqua,
    inversePrimary = md_theme_dark_inversePrimary_aqua,
    surfaceTint = md_theme_dark_surfaceTint_aqua,
    outlineVariant = md_theme_dark_outlineVariant_aqua,
    scrim = md_theme_dark_scrim_aqua,
)


@Composable
fun FinePhoneTheme(
    appTheme: AppTheme,
    appThemeColor: AppThemeColor,
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    content: @Composable () -> Unit
) {
    val colorScheme = when (appThemeColor) {
        AppThemeColor.Black -> {
            when (appTheme) {
                AppTheme.Dark -> DarkColorsBlack
                AppTheme.Light -> LightColorsBlack
                AppTheme.Default -> if (darkTheme) DarkColorsBlack else LightColorsBlack
            }
        }

        AppThemeColor.Silver -> {
            when (appTheme) {
                AppTheme.Dark -> DarkColorsSilver
                AppTheme.Light -> LightColorsSilver
                AppTheme.Default -> if (darkTheme) DarkColorsSilver else LightColorsSilver
            }
        }

        AppThemeColor.Gray -> {
            when (appTheme) {
                AppTheme.Dark -> DarkColorsGray
                AppTheme.Light -> LightColorsGray
                AppTheme.Default -> if (darkTheme) DarkColorsGray else LightColorsGray
            }
        }

        AppThemeColor.White -> {
            when (appTheme) {
                AppTheme.Dark -> DarkColorsWhite
                AppTheme.Light -> LightColorsWhite
                AppTheme.Default -> if (darkTheme) DarkColorsWhite else LightColorsWhite
            }
        }

        AppThemeColor.Maroon -> {
            when (appTheme) {
                AppTheme.Dark -> DarkColorsMaroon
                AppTheme.Light -> LightColorsMaroon
                AppTheme.Default -> if (darkTheme) DarkColorsMaroon else LightColorsMaroon
            }
        }

        AppThemeColor.Red -> {
            when (appTheme) {
                AppTheme.Dark -> DarkColorsRed
                AppTheme.Light -> LightColorsRed
                AppTheme.Default -> if (darkTheme) DarkColorsRed else LightColorsRed
            }
        }

        AppThemeColor.Purple -> {
            when (appTheme) {
                AppTheme.Dark -> DarkColorsPurple
                AppTheme.Light -> LightColorsPurple
                AppTheme.Default -> if (darkTheme) DarkColorsPurple else LightColorsPurple
            }
        }

        AppThemeColor.Fuchsia -> {
            when (appTheme) {
                AppTheme.Dark -> DarkColorsFuchsia
                AppTheme.Light -> LightColorsFuchsia
                AppTheme.Default -> if (darkTheme) DarkColorsFuchsia else LightColorsFuchsia
            }
        }

        AppThemeColor.Green -> {
            when (appTheme) {
                AppTheme.Dark -> DarkColorsGreen
                AppTheme.Light -> LightColorsGreen
                AppTheme.Default -> if (darkTheme) DarkColorsGreen else LightColorsGreen
            }
        }

        AppThemeColor.Lime -> {
            when (appTheme) {
                AppTheme.Dark -> DarkColorsLime
                AppTheme.Light -> LightColorsLime
                AppTheme.Default -> if (darkTheme) DarkColorsLime else LightColorsLime
            }
        }

        AppThemeColor.Olive -> {
            when (appTheme) {
                AppTheme.Dark -> DarkColorsOlive
                AppTheme.Light -> LightColorsOlive
                AppTheme.Default -> if (darkTheme) DarkColorsOlive else LightColorsOlive
            }
        }

        AppThemeColor.Yellow -> {
            when (appTheme) {
                AppTheme.Dark -> DarkColorsYellow
                AppTheme.Light -> LightColorsYellow
                AppTheme.Default -> if (darkTheme) DarkColorsYellow else LightColorsYellow
            }
        }

        AppThemeColor.Navy -> {
            when (appTheme) {
                AppTheme.Dark -> DarkColorsNavy
                AppTheme.Light -> LightColorsNavy
                AppTheme.Default -> if (darkTheme) DarkColorsNavy else LightColorsNavy
            }
        }

        AppThemeColor.Teal -> {
            when (appTheme) {
                AppTheme.Dark -> DarkColorsTeal
                AppTheme.Light -> LightColorsTeal
                AppTheme.Default -> if (darkTheme) DarkColorsTeal else LightColorsTeal
            }
        }

        AppThemeColor.Blue -> {
            when (appTheme) {
                AppTheme.Dark -> DarkColorsBlue
                AppTheme.Light -> LightColorsBlue
                AppTheme.Default -> if (darkTheme) DarkColorsBlue else LightColorsBlue
            }
        }

        AppThemeColor.Aqua -> {
            when (appTheme) {
                AppTheme.Dark -> DarkColorsAqua
                AppTheme.Light -> LightColorsAqua
                AppTheme.Default -> if (darkTheme) DarkColorsAqua else LightColorsAqua
            }
        }

        AppThemeColor.Dynamic -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val context = LocalContext.current
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)

                when (appTheme) {
                    AppTheme.Dark -> dynamicDarkColorScheme(context)
                    AppTheme.Light -> dynamicLightColorScheme(context)
                    AppTheme.Default -> if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(
                        context
                    )
                }
            } else {
                when (appTheme) {
                    AppTheme.Dark -> DarkColorsBlack
                    AppTheme.Light -> LightColorsBlack
                    AppTheme.Default -> if (darkTheme) DarkColorsBlack else LightColorsBlack
                }
            }
        }
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}