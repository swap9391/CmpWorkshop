package ui.screens.usermanagement

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.backhandler.BackHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import cmpworkshop.composeapp.generated.resources.Res
import cmpworkshop.composeapp.generated.resources.ic_completed
import cmpworkshop.composeapp.generated.resources.text_verificaion_success_subtitle
import cmpworkshop.composeapp.generated.resources.text_you_are_verified
import theme.textstyle.MyTextStyle
import org.jetbrains.compose.resources.stringResource
import theme.ComposeWorkShopTheme
import ui.AppConstants
import ui.components.button.MyMainButton
import ui.components.imageview.MyImageView
import ui.components.textView.MyTextView

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EmailVerificationSuccessScreen(navHostController: NavHostController? = null) {
    BackHandler {
        //Back restricted
    }

    ComposeWorkShopTheme {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {

            val (completedIcon, title, subtitle, btnContinue) = createRefs()

            MyImageView(imageRes = Res.drawable.ic_completed,
                modifier = Modifier
                    .height(400.dp)
                    /*.height(167.dp)
                    .width(260.dp)*/
                    .constrainAs(completedIcon) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .padding(top = 183.dp, start = 40.dp, end = 40.dp))


            MyTextView(
                text = stringResource(Res.string.text_you_are_verified),
                textStyle = MyTextStyle.TitleBold22,
                textAlign = TextAlign.Center,
                textColor = MaterialTheme.colorScheme.primaryContainer,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(title) {
                        top.linkTo(completedIcon.bottom)
                    }
                    .padding(top = 30.dp)
            )

            MyTextView(
                text = stringResource(Res.string.text_verificaion_success_subtitle) +
                        "Kindly proceed to log in ",
                textStyle = MyTextStyle.TitleLight14,
                textAlign = TextAlign.Center,
                textColor = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(subtitle) {
                        top.linkTo(title.bottom)
                    }
                    .padding(top = 5.dp)
            )

            MyMainButton(buttonTitle = "Continue",
                modifier = Modifier
                    .padding(25.dp)
                    .constrainAs(btnContinue) {
                        top.linkTo(subtitle.bottom)
                    }, onClick = {
                    navHostController?.navigate(AppConstants.KEY_NAVIGATE_HOME)
                })
        }
    }
}

