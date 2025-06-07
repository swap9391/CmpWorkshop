package ui.screens.usermanagement

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.backhandler.BackHandler
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import cmpworkshop.composeapp.generated.resources.Res
import cmpworkshop.composeapp.generated.resources.text_button_verify
import cmpworkshop.composeapp.generated.resources.text_not_received_code
import cmpworkshop.composeapp.generated.resources.text_resend
import cmpworkshop.composeapp.generated.resources.text_verification_code
import cmpworkshop.composeapp.generated.resources.text_verification_code_subtext
import theme.textstyle.MyTextStyle
import org.jetbrains.compose.resources.stringResource
import theme.ComposeWorkShopTheme
import ui.AppConstants
import ui.components.button.MyMainButton
import ui.components.edittext.MySmallEditText
import ui.components.textView.HyperLinkTextView
import ui.components.textView.MyTextView

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EmailVerificationScreen(navHostController: NavHostController? = null) {

    BackHandler {
        //Back restricted
    }

    ComposeWorkShopTheme {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {

            val (hyperText) = createRefs()


            val focusRequester1 = remember { FocusRequester() }
            val focusRequester2 = remember { FocusRequester() }
            val focusRequester3 = remember { FocusRequester() }
            val focusRequester4 = remember { FocusRequester() }



            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.padding(50.dp))
                MyTextView(
                    text = stringResource(Res.string.text_verification_code),
                    textStyle = MyTextStyle.TitleBold22,
                    textColor = MaterialTheme.colorScheme.primaryContainer,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp)
                )

                MyTextView(
                    text = stringResource(Res.string.text_verification_code_subtext),
                    textStyle = MyTextStyle.TitleLight14,
                    textColor = MaterialTheme.colorScheme.secondary,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp)
                )

                Spacer(modifier = Modifier.padding(top = 45.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    MySmallEditText(
                        text = "",
                        isBorder = true,
                        textStyle = MyTextStyle.TitleLight36,
                        keyboardType = KeyboardType.Number,
                        textLength = 1,
                        modifier = Modifier
                            .width(66.dp)
                            .height(88.dp)
                            .focusRequester(focusRequester1),
                        onValueChange = {
                            if (it.length <= 1) {
                                if (it.isNotEmpty()) {
                                    focusRequester2.requestFocus() // Move focus to next
                                }
                            }
                        }
                    )

                    Spacer(modifier = Modifier.padding(start = 20.dp))

                    MySmallEditText(
                        text = "", isBorder = true,
                        textStyle = MyTextStyle.TitleLight36,
                        keyboardType = KeyboardType.Number,
                        textLength = 1,
                        modifier = Modifier
                            .width(66.dp)
                            .height(88.dp).focusRequester(focusRequester2),
                        onValueChange = {
                            if (it.length <= 1) {
                                if (it.isNotEmpty()) {
                                    focusRequester3.requestFocus() // Move focus to next
                                }else{
                                    focusRequester1.requestFocus()
                                }
                            }
                        }
                    )

                    Spacer(modifier = Modifier.padding(start = 20.dp))


                    MySmallEditText(
                        text = "",  isBorder = true,
                        textStyle = MyTextStyle.TitleLight36,
                        keyboardType = KeyboardType.Number,
                        textLength = 1,
                        modifier = Modifier
                            .width(66.dp)
                            .height(88.dp).focusRequester(focusRequester3),
                        onValueChange = {
                            if (it.length <= 1) {
                                if (it.isNotEmpty()) {
                                    focusRequester4.requestFocus() // Move focus to next
                                }else{
                                    focusRequester2.requestFocus()
                                }
                            }
                        }
                    )

                    Spacer(modifier = Modifier.padding(start = 20.dp))

                    MySmallEditText(
                        text = "", isBorder = true,
                        textStyle = MyTextStyle.TitleLight36,
                        keyboardType = KeyboardType.Number,
                        textLength = 1,
                        modifier = Modifier
                            .width(66.dp)
                            .height(88.dp).focusRequester(focusRequester4),
                        onValueChange = {
                            if (it.length <= 1) {
                                if (it.isEmpty()) {
                                    focusRequester3.requestFocus() // Move focus to next
                                }
                            }
                        }
                    )
                }


                Spacer(modifier = Modifier.padding(top = 20.dp))

                MyMainButton(
                    buttonTitle = stringResource(Res.string.text_button_verify),
                    modifier = Modifier.padding(25.dp), onClick ={
                        navHostController?.navigate(AppConstants.KEY_NAVIGATE_VERIFICATION_SUCCESS)
                    }
                )
                Spacer(modifier = Modifier.padding(top = 20.dp))

            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp).constrainAs(hyperText){
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    },
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                MyTextView(
                    text = stringResource(Res.string.text_not_received_code),
                    textStyle = MyTextStyle.TitleMedium14,
                    textColor = MaterialTheme.colorScheme.secondary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(end = 5.dp)
                )
                HyperLinkTextView(
                    onClick = {
                       /* navHostController?.navigate(AppConstants.KEY_NAVIGATE_LOGIN) {
                            popUpTo(AppConstants.KEY_NAVIGATE_SIGNUP) {
                                inclusive = true
                            }
                        }*/
                    },
                    text = stringResource(Res.string.text_resend),
                    textStyle = MyTextStyle.TitleMedium14,
                )
            }

        }

    }
}
