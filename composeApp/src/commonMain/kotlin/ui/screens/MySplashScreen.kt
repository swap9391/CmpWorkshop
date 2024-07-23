package ui.screens

//import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.navigation.NavHostController
import cmpworkshop.composeapp.generated.resources.*
import com.kocfour.mykmpworkshop.ui.theme.textstyle.MyTextStyle
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
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

         navHostController.navigate(AppConstants.KEY_NAVIGATE_LOGIN){
             popUpTo(AppConstants.KEY_NAVIGATE_SPLASH){
                 inclusive = true
             }
         }
     }



     Box(modifier = Modifier
         .fillMaxSize()
         .paint(
             painterResource(resource = Res.drawable.img_splash_screen_background),
             contentScale = ContentScale.None
         ),
        contentAlignment = Alignment.Center){

        Image(
            modifier = Modifier
                .width(230.dp)
                .height(250.dp),
            painter = painterResource(resource = Res.drawable.img_splash_water_drop_blue),
            contentDescription = "WaterDrop Blue")

        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Spacer(modifier = Modifier.padding(100.dp))
            MyTextView(text = stringResource(resource = Res.string.text_drop_water_tracker), textStyle = MyTextStyle.TitleBold24, textColor = WhiteColor)
            MyTextView(text = stringResource(resource = Res.string.text_drop_water_tracker_subtitle),
                textStyle = MyTextStyle.TitleMedium14, textAlign = TextAlign.Center, textColor = WhiteColor,
                modifier = Modifier
                    .alpha(0.7f)
                    .padding(start = 80.dp, end = 80.dp))
          }

    }
}