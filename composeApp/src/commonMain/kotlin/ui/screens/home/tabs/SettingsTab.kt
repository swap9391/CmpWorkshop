package ui.screens.home.tabs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import theme.textstyle.MyTextStyle
import ui.components.textView.MyTextView

/**
 * Composable function that represents the search screen of the application.
 */
@Composable
fun SettingsTab() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        MyTextView(
            text = "Settings Screen",
            textStyle = MyTextStyle.TitleLight18,
            textColor = MaterialTheme.colorScheme.primaryContainer
        )
    }
}