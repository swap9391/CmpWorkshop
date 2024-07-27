package ui.screens.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ui.screens.onboarding.model.OnboardingScreenDetails
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle
import ui.components.imageview.MyImageView
import ui.components.textView.MyTextView

@Composable
fun OnboardingScreenContent(screen: OnboardingScreenDetails) {
    Column(
        modifier = Modifier.wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyImageView(
            imageRes = screen.imageRes,
            modifier = Modifier.size(300.dp)
        )

        Spacer(modifier = Modifier.padding(top=25.dp))


        Column(Modifier.height(130.dp),horizontalAlignment = Alignment.CenterHorizontally) {

        MyTextView(text = screen.title, textStyle = MyTextStyle.TitleBold24, textColor = MaterialTheme.colorScheme.primaryContainer, textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.padding(top=25.dp))

        MyTextView(text = screen.subtitle,
            textStyle = MyTextStyle.TitleMedium14, textAlign = TextAlign.Center, textColor = MaterialTheme.colorScheme.secondary)
        }
    }
}

