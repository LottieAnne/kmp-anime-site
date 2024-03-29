package jp.co.yumemi.navigation

import androidx.navigation.NavController
import jp.co.yumemi.features.splash.SplashNavigator

class SplashNavigation : SplashNavigator {
    override lateinit var navController: NavController

    override fun tutorial() {
        navController.navigate(AppNavGraphDirections.actionFromSplashToTutorial())
    }

    override fun workList() {
        navController.navigate(AppNavGraphDirections.actionFromSplashToWorkList())
    }
}
