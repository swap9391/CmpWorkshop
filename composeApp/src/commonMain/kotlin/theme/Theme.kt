package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


val ColorLightPrimaryBlue = Color(0xFF62CDFA)
val ColorLightBlackText = Color(0xFF141A1E)
val ColorLightPrimaryText = Color(0xFF575757)
val ColorSecondaryText = Color(0xFF8E8E8E)


private val LightColorScheme = lightColorScheme(
    background = WhiteColor,
    surface = WhiteColor,
    primary = ColorLightPrimaryBlue,
    secondary = ColorLightPrimaryText,
    primaryContainer = ColorLightBlackText
)

private val DarkColorScheme = darkColorScheme(
    background = ColorLightBlackText,
    surface = ColorLightBlackText,
    primary = ColorLightPrimaryBlue,
    secondary = WhiteColor,
    primaryContainer = WhiteColor
)

@Composable
fun ComposeWorkShopTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        /*dynamicColor -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }*/
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}