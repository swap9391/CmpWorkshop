package ui.screens.home.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import cmpworkshop.composeapp.generated.resources.Res
import cmpworkshop.composeapp.generated.resources.*
import theme.textstyle.MyTextStyle
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import theme.SecondaryBlueTextColor
import ui.components.button.MyMainButton
import ui.components.edittext.MyEditText
import ui.components.imageview.MyImageView
import ui.components.radiogroup.MyRadioGroup
import ui.components.slider.MySlider
import ui.components.textView.MyTextView
import ui.components.toolbar.MyToolbar

/**
 * Composable function that represents the profile screen of the application.
 */
@Composable
fun ProfileTab() {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        val isUpdate = rememberSaveable { mutableStateOf(false) }

        val firstNameText = rememberSaveable { mutableStateOf("") }
        val lastNameText = rememberSaveable { mutableStateOf("") }
        val emailAddressText = rememberSaveable { mutableStateOf("") }
        val ageText = rememberSaveable { mutableStateOf("") }
        val genderText = rememberSaveable { mutableStateOf("Male") }
        val userWeight = rememberSaveable { mutableFloatStateOf(60F) }
        val userHeight = rememberSaveable { mutableFloatStateOf(125F) }



        MyToolbar(title = stringResource(Res.string.text_edit_profile),
            imageRes = Res.drawable.ic_edit,
            isBack = true,
            isMenu = true,
            onMenuClick = { isUpdate.value = true },
            modifier = Modifier,
            onBackPress = {
            //    Log.d("TAG", "Back Clicked")
            })


        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            val (profilePic, labelFirstName, labelLastName, labelEmailAddress, labelAge, labelGender, radioGender, btnUpdate,
                textFieldFirstName, textFieldLastName, textFieldAge, textFieldEmailAddress,labelWeight,labelHeight,sliderWeight,sliderHeight) = createRefs()



            MyImageView(
                imageRes = getProfileImageResource(genderText, ageText),
                modifier = Modifier
                    .constrainAs(profilePic) {
                        top.linkTo(parent.top, margin = 14.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)

                    }
                    .height(100.dp)
                    .width(100.dp))

            MyTextView(
                text = stringResource(Res.string.text_first_name),
                textStyle = MyTextStyle.TitleMedium16,
                modifier = Modifier.constrainAs(labelFirstName) {
                    top.linkTo(profilePic.bottom, margin = 23.dp)
                    start.linkTo(parent.start, margin = 23.dp)
                })

            MyEditText(hint = stringResource(Res.string.text_enter_first_name), text = firstNameText.value,
                hintTextStyle = MyTextStyle.TitleMedium14,
                textStyle = MyTextStyle.TitleMedium14,
                containerColor = SecondaryBlueTextColor,
                isEnable = isUpdate.value,
                modifier = Modifier
                    .constrainAs(textFieldFirstName) {
                        top.linkTo(labelFirstName.bottom, margin = 7.dp)
                        start.linkTo(parent.start, margin = 23.dp)
                        end.linkTo(parent.end, margin = 25.dp)
                    }
                    .fillMaxWidth()
                    .padding(start = 23.dp, end = 23.dp), onValueChange = {
                    firstNameText.value = it
                })


            MyTextView(
                text = stringResource(Res.string.text_last_name),
                textStyle = MyTextStyle.TitleMedium16,
                modifier = Modifier.constrainAs(labelLastName) {
                    top.linkTo(textFieldFirstName.bottom, margin = 13.dp)
                    start.linkTo(parent.start, margin = 23.dp)
                })

            MyEditText(hint = stringResource(Res.string.text_enter_last_name), text = lastNameText.value,
                hintTextStyle = MyTextStyle.TitleMedium14,
                textStyle = MyTextStyle.TitleMedium14,
                containerColor = SecondaryBlueTextColor,
                isEnable = isUpdate.value,
                modifier = Modifier
                    .constrainAs(textFieldLastName) {
                        top.linkTo(labelLastName.bottom, margin = 7.dp)
                        start.linkTo(parent.start, margin = 23.dp)
                        end.linkTo(parent.end, margin = 25.dp)
                    }
                    .fillMaxWidth()
                    .padding(start = 23.dp, end = 23.dp), onValueChange = {
                    lastNameText.value = it
                })


            MyTextView(
                text = stringResource(Res.string.text_age),
                textStyle = MyTextStyle.TitleMedium16, modifier = Modifier.constrainAs(labelAge) {
                    top.linkTo(textFieldLastName.bottom, margin = 13.dp)
                    start.linkTo(parent.start, margin = 23.dp)
                })

            MyEditText(hint = stringResource(Res.string.text_enter_age), text = ageText.value,
                hintTextStyle = MyTextStyle.TitleMedium14,
                textStyle = MyTextStyle.TitleMedium14,
                containerColor = SecondaryBlueTextColor,
                keyboardType = KeyboardType.Number,
                textLength = 3,
                isEnable = isUpdate.value,
                modifier = Modifier
                    .constrainAs(textFieldAge) {
                        top.linkTo(labelAge.bottom, margin = 7.dp)
                        start.linkTo(parent.start, margin = 23.dp)
                        end.linkTo(parent.end, margin = 25.dp)
                    }
                    .fillMaxWidth()
                    .padding(start = 23.dp, end = 23.dp), onValueChange = {
                    if (it.isEmpty() || (it.toIntOrNull() ?: 0) in 0..110) {
                        ageText.value = it
                    }
                })


            MyTextView(
                text = stringResource(Res.string.text_email_address),
                textStyle = MyTextStyle.TitleMedium16,
                modifier = Modifier.constrainAs(labelEmailAddress) {
                    top.linkTo(textFieldAge.bottom, margin = 13.dp)
                    start.linkTo(parent.start, margin = 23.dp)
                })

            MyEditText(hint = stringResource(Res.string.text_enter_email_address), text = emailAddressText.value,
                hintTextStyle = MyTextStyle.TitleMedium14,
                textStyle = MyTextStyle.TitleMedium14,
                containerColor = SecondaryBlueTextColor,
                keyboardType = KeyboardType.Email,
                isEnable = isUpdate.value,
                modifier = Modifier
                    .constrainAs(textFieldEmailAddress) {
                        top.linkTo(labelEmailAddress.bottom, margin = 7.dp)
                        start.linkTo(parent.start, margin = 23.dp)
                        end.linkTo(parent.end, margin = 25.dp)
                    }
                    .fillMaxWidth()
                    .padding(start = 23.dp, end = 23.dp), onValueChange = {
                    emailAddressText.value = it
                })


            MyTextView(
                text = stringResource(Res.string.text_gender),
                textStyle = MyTextStyle.TitleMedium16,
                modifier = Modifier.constrainAs(labelGender) {
                    top.linkTo(textFieldEmailAddress.bottom, margin = 13.dp)
                    start.linkTo(parent.start, margin = 23.dp)
                })

            MyRadioGroup(list = listOf(stringResource(Res.string.text_male), stringResource(Res.string.text_female)),
                selectedValue = genderText.value,
                modifier = Modifier.constrainAs(radioGender) {
                    top.linkTo(labelGender.bottom, margin = 13.dp)
                    start.linkTo(parent.start, margin = 13.dp)
                },
                isEnable = isUpdate.value,
                onGenderSelected = {
                    genderText.value = it
                })

            MyTextView(
                text = stringResource(Res.string.text_user_weight_label),
                textStyle = MyTextStyle.TitleMedium16,
                modifier = Modifier.constrainAs(labelWeight) {
                    top.linkTo(radioGender.bottom, margin = 13.dp)
                    start.linkTo(labelGender.start)
                }.fillMaxWidth())

            MySlider(
                modifier = Modifier.padding(start = 20.dp, end = 40.dp)
                    .constrainAs(sliderWeight) {
                        top.linkTo(labelWeight.bottom, margin = 7.dp)
                        start.linkTo(labelWeight.start)
                        end.linkTo(parent.end)

                    },
                value = userWeight.value,
                range = 0f..200f, {}
            )


            MyTextView(
                text = stringResource(Res.string.text_user_height_label),
                textStyle = MyTextStyle.TitleMedium16,
                modifier = Modifier.constrainAs(labelHeight) {
                    top.linkTo(sliderWeight.bottom, margin = 13.dp)
                    start.linkTo(labelGender.start)
                }.fillMaxWidth())

            MySlider(
                modifier = Modifier.padding(start = 20.dp, end = 40.dp)
                    .constrainAs(sliderHeight) {
                        top.linkTo(labelHeight.bottom, margin = 7.dp)
                        start.linkTo(labelHeight.start)
                        end.linkTo(parent.end)

                    },
                value = userWeight.value,
                range = 0f..200f, {}
            )

            //Todo Need to add text for Thumb




            if (isUpdate.value) {
                MyMainButton(buttonTitle = stringResource(Res.string.text_update), isUpperCase = false,
                    modifier = Modifier
                        .constrainAs(btnUpdate) {
                            top.linkTo(sliderHeight.bottom, margin = 13.dp)
                            start.linkTo(parent.start, margin = 23.dp)
                            end.linkTo(parent.end, margin = 23.dp)
                            bottom.linkTo(parent.bottom, margin = 30.dp)
                        }
                        .width(121.dp)
                        .padding(bottom = 30.dp))
            }

        }
    }
}

@Composable
private fun getProfileImageResource(
    genderText: MutableState<String>,
    ageText: MutableState<String>
) = when {

    genderText.value == stringResource(Res.string.text_male) && ageText.value.isEmpty() -> {
        Res.drawable.ic_profile_male_junior
    }

    genderText.value == stringResource(Res.string.text_female) && ageText.value.isEmpty() -> {
        Res.drawable.ic_profile_female_junior
    }

    genderText.value == stringResource(Res.string.text_male) && ageText.value.toInt() < 18 -> {
        Res.drawable.ic_profile_male_junior
    }

    genderText.value == stringResource(Res.string.text_male) && ageText.value.toInt() > 18 && ageText.value.toInt() < 60 -> {
        Res.drawable.ic_profile_male
    }

    genderText.value == stringResource(Res.string.text_male) && ageText.value.toInt() > 60 -> {
        Res.drawable.ic_profile_male_senior
    }

    genderText.value == stringResource(Res.string.text_female) && ageText.value.toInt() < 18 -> {
        Res.drawable.ic_profile_female_junior
    }

    genderText.value == stringResource(Res.string.text_female) && ageText.value.toInt() > 18 && ageText.value.toInt() < 60 -> {
        Res.drawable.ic_profile_female
    }

    genderText.value == stringResource(Res.string.text_female) && ageText.value.toInt() > 60 -> {
        Res.drawable.ic_profile_female_senior
    }

    else -> {
        Res.drawable.ic_profile_male_junior
    }
}

@Preview
@Composable
fun DefaultPreview() {
    ProfileTab()
}
