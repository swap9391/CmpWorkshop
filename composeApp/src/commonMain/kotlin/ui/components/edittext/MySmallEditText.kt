package ui.components.edittext

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle
import theme.ColorLightPrimaryText
import theme.GreyColor
import theme.PrimaryBlueTextColor
import theme.textstyle.TypographyUtils

@Composable
fun MySmallEditText(
    text: String,
    keyboardType: KeyboardType = KeyboardType.Number,
    textStyle: MyTextStyle = MyTextStyle.TitleLight14,
    isBorder:Boolean=false,
    textLength: Int = 1,
    modifier: Modifier = Modifier,
    onValueChange: ((updatedValue: String) -> Unit)
) {
    var input by rememberSaveable { mutableStateOf(text) }

    OutlinedTextField(
        value = input,
        modifier = modifier.apply {
            fillMaxWidth()
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = if (isBorder){
                PrimaryBlueTextColor
            }else{
                Color.Transparent
            },
            unfocusedIndicatorColor = if (isBorder){
                PrimaryBlueTextColor
            }else{
                Color.Transparent
            },
            cursorColor = Color.Transparent,
            unfocusedContainerColor = GreyColor,
            focusedContainerColor = GreyColor,
            focusedTextColor = ColorLightPrimaryText,
            unfocusedTextColor = ColorLightPrimaryText,
        ),
        textStyle = TypographyUtils.getKKTextStyle(textStyle).getSmallTextStyle(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, autoCorrect = false),
        onValueChange = { newValue ->
            if (newValue.length <= textLength) {
                input = newValue
                onValueChange.invoke(newValue)
            }
        }
    )
}


fun TextStyle.getSmallTextStyle(): TextStyle {
    return TextStyle(
        textAlign = TextAlign.Center,
        fontFamily = this.fontFamily,
        fontSize = this.fontSize,
        fontWeight = this.fontWeight)
}