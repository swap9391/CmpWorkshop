import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import theme.ComposeWorkShopTheme
import ui.AppConstants
import ui.screens.home.HomeScreen
import ui.screens.onboarding.WelcomeSlideViewScreen
import ui.screens.usermanagement.EmailVerificationScreen
import ui.screens.usermanagement.EmailVerificationSuccessScreen
import ui.screens.usermanagement.LogInScreen
import ui.screens.usermanagement.MySplashScreen
import ui.screens.usermanagement.SignUpScreen

@Composable
@Preview
fun App() {

    ComposeWorkShopTheme {
        Surface(color = androidx.compose.material3.MaterialTheme.colorScheme.background) {

            val navHostController = rememberNavController()

            NavHost(navController = navHostController, startDestination = AppConstants.KEY_NAVIGATE_SPLASH) {
                composable(AppConstants.KEY_NAVIGATE_SPLASH) {
                    MySplashScreen( navHostController)
                }
                composable(AppConstants.KEY_NAVIGATE_ONBOARDING) {
                    WelcomeSlideViewScreen( navHostController)
                }
                composable(AppConstants.KEY_NAVIGATE_LOGIN) {
                    LogInScreen(navHostController)
                }
                composable(AppConstants.KEY_NAVIGATE_SIGNUP) {
                    SignUpScreen(navHostController)
                }
                composable(AppConstants.KEY_NAVIGATE_VERIFICATION) {
                    EmailVerificationScreen(navHostController)
                }
                composable(AppConstants.KEY_NAVIGATE_VERIFICATION_SUCCESS) {
                    EmailVerificationSuccessScreen(navHostController)
                }
                composable(AppConstants.KEY_NAVIGATE_HOME) {
                    HomeScreen()
                }

            }

        }
    }


/*
    MaterialTheme {

        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            Text("Hello World!")
        }

      *//*  var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }*//*
    }*/
}