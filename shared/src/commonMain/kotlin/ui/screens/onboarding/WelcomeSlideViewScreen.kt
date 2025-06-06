package ui.screens.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import cmpworkshop.shared.generated.resources.Res
import cmpworkshop.shared.generated.resources.img_slider_1
import cmpworkshop.shared.generated.resources.img_slider_2
import cmpworkshop.shared.generated.resources.img_slider_3
import cmpworkshop.shared.generated.resources.text_get_started
import cmpworkshop.shared.generated.resources.text_next
import cmpworkshop.shared.generated.resources.text_skip_all
import cmpworkshop.shared.generated.resources.text_subtitle_slide_one
import cmpworkshop.shared.generated.resources.text_subtitle_slide_three
import cmpworkshop.shared.generated.resources.text_subtitle_slide_two
import cmpworkshop.shared.generated.resources.text_title_slide_one
import cmpworkshop.shared.generated.resources.text_title_slide_three
import cmpworkshop.shared.generated.resources.text_title_slide_two
import theme.textstyle.MyTextStyle
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import theme.PrimaryBlueTextColor
import theme.PrimaryLightBlueTextColor
import ui.AppConstants
import ui.components.button.MyMainButton
import ui.components.textView.HyperLinkTextView
import ui.screens.onboarding.model.OnboardingScreenDetails

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeSlideViewScreen(navHostController: NavHostController? = null) {

    val onboardingScreens = listOf(
        OnboardingScreenDetails(
            title = stringResource(resource = Res.string.text_title_slide_one),
            subtitle = stringResource(resource = Res.string.text_subtitle_slide_one),
            buttonText = "Next",
            imageRes = Res.drawable.img_slider_1 // Replace with your actual drawable
        ),
        OnboardingScreenDetails(
            title = stringResource(resource = Res.string.text_title_slide_two),
            subtitle = stringResource(resource = Res.string.text_subtitle_slide_two),
            buttonText = "Next",
            imageRes = Res.drawable.img_slider_2 // Replace with your actual drawable
        ),
        OnboardingScreenDetails(
            title = stringResource(resource = Res.string.text_title_slide_three),
            subtitle = stringResource(resource = Res.string.text_subtitle_slide_three),
            buttonText = "Next",
            imageRes = Res.drawable.img_slider_3 // Replace with your actual drawable
        )
        // ... add more onboarding screens
    )


    val pagerState = rememberPagerState(pageCount = { onboardingScreens.size })

    val coroutineScope = rememberCoroutineScope()

    ConstraintLayout(Modifier.fillMaxSize()) {
        val (pager, indicator, button,skip) = createRefs()


        HyperLinkTextView(
            text = stringResource(Res.string.text_skip_all),
            textStyle = MyTextStyle.TitleLight14,
            unselectedColor = PrimaryBlueTextColor,
            selectedColor = PrimaryLightBlueTextColor,
            modifier = Modifier
                .constrainAs(skip) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .padding(end = 25.dp, top = 25.dp),
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(2)
                }
            }
        )

        HorizontalPager(
            state = pagerState,
            Modifier
                .constrainAs(pager) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(top = 70.dp),
            contentPadding = PaddingValues(horizontal = 10.dp), pageSpacing = 10.dp
        ) { page ->

            OnboardingScreenContent(screen = onboardingScreens[page])
           /* LaunchedEffect(pagerState) {
                snapshotFlow { pagerState.currentPage }
                    .collect { currentPage ->
                        pagerState.animateScrollToPage(currentPage)
                    }
            }*/
        }


        Box(
            modifier = Modifier
                .constrainAs(indicator) {
                    top.linkTo(pager.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(top = 20.dp)
        ) {
            IndicatorDots(
                currentPage = pagerState.currentPage,
                totalPages = onboardingScreens.size
            )
        }

        MyMainButton(buttonTitle = when (pagerState.currentPage) {
            2 -> {
                stringResource(Res.string.text_get_started)
            }

            else -> {
                stringResource(Res.string.text_next)
            }
        }, modifier = Modifier
            .padding(25.dp)
            .constrainAs(button) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            .padding(bottom = 20.dp),
            onClick = {
                when (pagerState.currentPage) {
                    2 -> {
                        navHostController?.navigate(AppConstants.KEY_NAVIGATE_LOGIN)
                    }

                    else -> {
                        val nextPage = (pagerState.currentPage + 1)
                        // Use coroutineScope to launch the animation within the composable's lifecycle
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(nextPage)
                        }
                    }
                }
            })


    }
}
