package ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import theme.ComposeWorkShopTheme
import ui.components.bottomnavigation.BottomNavigationBar
import ui.screens.home.nav.NavItem
import ui.screens.home.tabs.HomeTab
import ui.screens.home.tabs.ListScreen
import ui.screens.home.tabs.ProfileScreen
import ui.screens.home.tabs.SearchScreen


@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    ComposeWorkShopTheme {
        Scaffold(
            /*topBar = {
                val title = getTitle(currentScreen)
                TopBar(
                    title = title,
                    canNavigateBack = currentScreen?.route == AppScreen.Detail.route,
                    navigateUp = { navController.navigateUp() }
                )
            },*/
            bottomBar = {
                BottomNavigationBar(navController)
            }
        ) { innerPadding ->

            NavHost(
                navController,
                startDestination = NavItem.Home.path,
                Modifier.padding(innerPadding)
            ) {
                composable(NavItem.Home.path) { HomeTab() }
                composable(NavItem.Search.path) { SearchScreen() }
                composable(NavItem.List.path) { ListScreen() }
                composable(NavItem.Profile.path) { ProfileScreen() }
            }

        }
    }
}