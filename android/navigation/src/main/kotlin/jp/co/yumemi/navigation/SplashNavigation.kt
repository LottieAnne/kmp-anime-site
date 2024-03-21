package jp.co.yumemi.navigation

import androidx.navigation.NavController
import jp.co.yumemi.features.splash.SplashNavigator

class SplashNavigation : SplashNavigator {
    override lateinit var navController: NavController

//    override fun home() {
//        navController.navigate(AppNavGraphDirections.actionHome())
//    }
}
