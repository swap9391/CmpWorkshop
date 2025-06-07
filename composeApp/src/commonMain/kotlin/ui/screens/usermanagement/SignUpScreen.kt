package ui.screens.usermanagement

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.backhandler.BackHandler
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cmpworkshop.composeapp.generated.resources.Res
import cmpworkshop.composeapp.generated.resources.ic_user_contact
import cmpworkshop.composeapp.generated.resources.ic_user_email
import cmpworkshop.composeapp.generated.resources.ic_user_fulname
import cmpworkshop.composeapp.generated.resources.ic_user_password
import cmpworkshop.composeapp.generated.resources.text_already_have_account
import cmpworkshop.composeapp.generated.resources.text_button_create_account
import cmpworkshop.composeapp.generated.resources.text_create_an_account
import cmpworkshop.composeapp.generated.resources.text_enter_contact
import cmpworkshop.composeapp.generated.resources.text_full_name
import cmpworkshop.composeapp.generated.resources.text_hint_email
import cmpworkshop.composeapp.generated.resources.text_hint_password
import cmpworkshop.composeapp.generated.resources.text_log_in
import cmpworkshop.composeapp.generated.resources.text_securely_login_to_your_account
import theme.textstyle.MyTextStyle
import org.jetbrains.compose.resources.stringResource
import theme.ComposeWorkShopTheme
import ui.AppConstants
import ui.components.button.MyMainButton
import ui.components.dropdown.MyDropDown
import ui.components.edittext.MyEditText
import ui.components.textView.HyperLinkTextView
import ui.components.textView.MyTextView

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpScreen(navHostController: NavHostController) {

    BackHandler {
        navHostController.navigate(AppConstants.KEY_NAVIGATE_LOGIN)
    }

    ComposeWorkShopTheme {
        Box(
            contentAlignment = Alignment.TopCenter, modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.padding(50.dp))
                MyTextView(
                    text = stringResource(Res.string.text_create_an_account),
                    textStyle = MyTextStyle.TitleBold22,
                    textColor = MaterialTheme.colorScheme.primaryContainer,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp)
                )

                MyTextView(
                    text = stringResource(Res.string.text_securely_login_to_your_account),
                    textStyle = MyTextStyle.TitleLight14,
                    textColor = MaterialTheme.colorScheme.secondary,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp)
                )
                Spacer(modifier = Modifier.padding(top = 45.dp))


                MyEditText(
                    text = "", hint = stringResource(Res.string.text_full_name),
                    icon = Res.drawable.ic_user_fulname,
                    keyboardType = KeyboardType.Text,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    onValueChange = {}
                )
                Spacer(modifier = Modifier.padding(top = 20.dp))


                MyEditText(
                    text = "", hint = stringResource(Res.string.text_hint_email),
                    icon = Res.drawable.ic_user_email,
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    onValueChange = {}
                )
                Spacer(modifier = Modifier.padding(top = 20.dp))


                Row {
                    MyDropDown(onCountryCodeSelected = {},
                        modifier = Modifier.wrapContentSize()
                            .align(Alignment.CenterVertically))

                    MyEditText(
                        text = "", hint = stringResource(Res.string.text_enter_contact),
                        icon = Res.drawable.ic_user_contact,
                        keyboardType = KeyboardType.Phone,
                        textLength = 12,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp, end = 25.dp),
                        onValueChange = {}
                    )
                }


                Spacer(modifier = Modifier.padding(top = 20.dp))


                MyEditText(
                    text = "",
                    hint = stringResource(Res.string.text_hint_password),
                    icon = Res.drawable.ic_user_password,
                    keyboardType = KeyboardType.Password,
                    isPassword = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    onValueChange = {}
                )

                MyMainButton(buttonTitle = stringResource(Res.string.text_button_create_account), modifier = Modifier.padding(25.dp),
                    onClick = {
                        navHostController.navigate(AppConstants.KEY_NAVIGATE_VERIFICATION)
                    },)
                Spacer(modifier = Modifier.padding(top = 20.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    MyTextView(
                        text = stringResource(Res.string.text_already_have_account),
                        textStyle = MyTextStyle.TitleMedium14,
                        textColor = MaterialTheme.colorScheme.secondary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(end = 5.dp)
                    )
                    HyperLinkTextView(
                        onClick = {
                            navHostController.navigate(AppConstants.KEY_NAVIGATE_LOGIN){
                                popUpTo(AppConstants.KEY_NAVIGATE_SIGNUP){
                                    inclusive = true
                                }
                            }
                        },
                        text = stringResource(Res.string.text_log_in),
                        textStyle = MyTextStyle.TitleMedium14,
                    )
                }

            }

        }

    }
}