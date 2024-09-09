package ui.components.toolbar

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cmpworkshop.composeapp.generated.resources.Res
import cmpworkshop.composeapp.generated.resources.ic_back
import cmpworkshop.composeapp.generated.resources.ic_edit
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import ui.components.textView.MyTextView

@Composable
fun MyToolbar(
    title: String,
    imageRes: DrawableResource=Res.drawable.ic_edit,
    isBack: Boolean,
    isMenu: Boolean,
    height: Dp = 56.dp,
    textStyle: MyTextStyle = MyTextStyle.TitleSemiBold18,
    onMenuClick: () -> Unit,
    onBackPress: () -> Unit,
    modifier: Modifier
) {
    Row(
        modifier
            .fillMaxWidth()
            .height(height),
    ) {

        var isBackPressed by remember { mutableStateOf(false) }

        var isMenuPressed by remember { mutableStateOf(false) }


        if (isBack) {
            IconButton(
                onClick = onBackPress, modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onPress = {
                                isBackPressed = true
                                tryAwaitRelease()
                                isBackPressed = false
                            })
                    }, colors = IconButtonColors(
                    contentColor = MaterialTheme.colorScheme.primary,
                    containerColor = Color.Unspecified,
                    disabledContainerColor = MaterialTheme.colorScheme.primary,
                    disabledContentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Icon(
                    painter = painterResource(resource = Res.drawable.ic_back),
                    tint = if (isBackPressed) Color.Red else Color.Unspecified,
                    contentDescription = "back"
                )
            }
        }
        MyTextView(
            text = title,
            textStyle = textStyle,
            textColor = MaterialTheme.colorScheme.primaryContainer,
            textAlign = TextAlign.Center,
            softWrap = true,
            maxLines = 2,
            modifier = Modifier
                .weight(weight = 1f)
                .wrapContentSize()
                .padding(end = if (isMenu) 0.dp else 54.dp)
                .align(Alignment.CenterVertically)
        )

        if (isMenu)
            IconButton(
                onClick = onMenuClick, modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onPress = {
                                isMenuPressed = true
                                tryAwaitRelease()
                                isMenuPressed = false
                            })
                    }) {
                Icon(
                    painter = painterResource(resource = imageRes),
                    tint = if (isMenuPressed) Color.Red else Color.Unspecified,
                    contentDescription = "menu"
                )
            }

    }
}

/*@Preview
@Composable
fun DefaultPreview() {
    MyToolbar(
        title = stringResource(R.string.text_profile_setting),
        imageRes = R.drawable.ic_edit,
        isBack = true,
        isMenu = false,
        textStyle = MyTextStyle.TitleSemiBold16,
        onMenuClick = {},
        onBackPress = {},
        modifier = Modifier
    )
}*/
