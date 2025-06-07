package ui.screens.home.nav

import cmpworkshop.composeapp.generated.resources.Res
import cmpworkshop.composeapp.generated.resources.*

sealed class NavItem {
    object Home :
        Item(path = NavPath.HOME.toString(), title = Res.string.text_home, icon = Res.drawable.ic_home)

    object Analysis :
        Item(path = NavPath.ANALYSIS.toString(), title = Res.string.text_analysis, icon = Res.drawable.ic_analysis)

    object Settings :
        Item(path = NavPath.SETTINGS.toString(), title = Res.string.text_settings, icon = Res.drawable.ic_settings)

    object Profile :
        Item(
            path = NavPath.PROFILE.toString(), title = Res.string.text_profile, icon = Res.drawable.ic_profile)
}