package ui.screens.usermanagement

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cmpworkshop.composeapp.generated.resources.Res
import cmpworkshop.composeapp.generated.resources.ic_spash_drops
import cmpworkshop.composeapp.generated.resources.img_splash_screen_background
import cmpworkshop.composeapp.generated.resources.img_splash_water_drop_blue
import cmpworkshop.composeapp.generated.resources.text_drop_water_tracker
import cmpworkshop.composeapp.generated.resources.text_drop_water_tracker_subtitle
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import theme.WhiteColor
import ui.AppConstants
import ui.components.textView.MyTextView


@Composable
 fun MySplashScreen(navHostController: NavHostController){

     val scale = remember {
         Animatable(0f)
     }

     LaunchedEffect(key1 = true) {
         /*scale.animateTo(
             targetValue = 0.6f,
             animationSpec = tween(
                 durationMillis = 1000,
                 *//*easing = {
                     OvershootInterpolator(4f).getInterpolation(it)
                 }*//*
             )
         )*/

         delay(1500L)

              navHostController.navigate(AppConstants.KEY_NAVIGATE_ONBOARDING)
     }


    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .paint(
            painterResource(resource = Res.drawable.img_splash_screen_background),
            contentScale = ContentScale.FillBounds
        )){

        val (blueDrop, whiteDrop,text) = createRefs()


        Image(
            modifier = Modifier.wrapContentSize()
                .constrainAs(blueDrop){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            painter = painterResource(resource = Res.drawable.img_splash_water_drop_blue),
            contentDescription = "WaterDrop Blue")

        Image(
            modifier = Modifier.padding(bottom = 45.dp, start = 15.dp)
                .width(157.dp)
                .height(171.dp).constrainAs(whiteDrop){
                    bottom.linkTo(text.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            painter = painterResource(resource = Res.drawable.ic_spash_drops),
            contentDescription = "WaterDrop Blue")

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.constrainAs(text){
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(blueDrop.bottom)
            }){
            MyTextView(text = stringResource(resource = Res.string.text_drop_water_tracker), textStyle = MyTextStyle.TitleBold24, textColor = WhiteColor)
            MyTextView(text = stringResource(resource = Res.string.text_drop_water_tracker_subtitle),
                textStyle = MyTextStyle.TitleMedium14, textAlign = TextAlign.Center, textColor = WhiteColor,
                modifier = Modifier
                    .alpha(0.7f)
                    .padding(start = 80.dp, end = 80.dp))
        }
    }
}

@Preview
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    MySplashScreen(navHostController = navController)

    /*ComposeWorkShopTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            HomeScreen()
        }
    }*/
}

