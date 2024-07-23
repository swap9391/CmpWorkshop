import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import theme.ComposeWorkShopTheme
import ui.AppConstants
import ui.screens.LogInScreen
import ui.screens.MySplashScreen
import ui.screens.SignUpScreen

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
                composable(AppConstants.KEY_NAVIGATE_LOGIN) {
                    LogInScreen(navHostController)
                }
                composable(AppConstants.KEY_NAVIGATE_SIGNUP) {
                    SignUpScreen(navHostController)
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