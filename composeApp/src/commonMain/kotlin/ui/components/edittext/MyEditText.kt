package ui.components.edittext

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import cmpworkshop.composeapp.generated.resources.Res
import cmpworkshop.composeapp.generated.resources.ic_user_email
import cmpworkshop.composeapp.generated.resources.ic_user_hide_password
import cmpworkshop.composeapp.generated.resources.ic_user_show_password
import theme.textstyle.MyTextStyle
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import theme.ColorLightPrimaryText
import theme.ColorSecondaryText
import theme.GreyColor
import theme.PrimaryBlueTextColor
import theme.SecondaryBlueTextColor
import theme.textstyle.TypographyUtils
import ui.components.textView.MyTextView

@Composable
fun MyEditText(
    hint: String,
    text: String,
    icon: DrawableResource? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    textStyle: MyTextStyle = MyTextStyle.TitleLight14,
    hintTextStyle: MyTextStyle = MyTextStyle.TitleLight12,
    textAlign: TextAlign = TextAlign.Left,
    isEnable: Boolean = true,
    isPassword: Boolean = false,
    isBorder: Boolean = false,
    textLength: Int = 250,
    modifier: Modifier = Modifier,
    containerColor: Color = GreyColor,
    onValueChange: ((updatedValue: String) -> Unit)
) {
    var input by rememberSaveable { mutableStateOf(text) }
    var passwordVisible by remember { mutableStateOf(false) } // State for password visibility

    OutlinedTextField(
        value = input,
        modifier = modifier.apply {
            fillMaxWidth()
        },
        leadingIcon = if (icon != null) {
            {
                Icon(
                    painter = painterResource(resource = icon),
                    contentDescription = "null", tint = Color.Unspecified
                )
            }
        } else null,
        placeholder = {
            MyTextView(
                text = hint,
                textStyle = hintTextStyle,
                textAlign = textAlign,
                textColor = ColorSecondaryText
            )
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = if (isBorder) {
                PrimaryBlueTextColor
            } else {
                Color.Transparent
            },
            unfocusedIndicatorColor = if (isBorder) {
                PrimaryBlueTextColor
            } else {
                Color.Transparent
            },
            cursorColor = PrimaryBlueTextColor,
            unfocusedContainerColor = containerColor,
            focusedContainerColor = containerColor,
            disabledContainerColor = GreyColor,
            focusedTextColor = ColorLightPrimaryText,
            unfocusedTextColor = ColorLightPrimaryText,
        ),
        textStyle = TypographyUtils.getKKTextStyle(textStyle),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, autoCorrect = false),
        visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = if (isPassword) {
            {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    if (passwordVisible) {
                        Icon(
                            painter = painterResource(resource = Res.drawable.ic_user_hide_password),
                            contentDescription = "null", tint = Color.Unspecified,
                        )
                    } else {
                        Icon(
                            painter = painterResource(resource = Res.drawable.ic_user_show_password),
                            contentDescription = "null", tint = Color.Unspecified
                        )
                    }
                }
            }
        } else null,
        enabled = isEnable,
        onValueChange = { newValue ->
            if (newValue.length <= textLength) {
                input = newValue
                onValueChange.invoke(newValue)
            }
        }
    )
}


@Preview
@Composable
fun DefaultPreview() {
    MyEditText(
        text = "", hint = "Enter Username",
        icon = Res.drawable.ic_user_email,
        containerColor = SecondaryBlueTextColor,
        onValueChange = {}
    )
}