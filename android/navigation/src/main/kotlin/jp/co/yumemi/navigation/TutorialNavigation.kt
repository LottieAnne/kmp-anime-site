package jp.co.yumemi.navigation

import androidx.navigation.NavController
import jp.co.yumemi.features.tutorial.TutorialFragmentDirections
import jp.co.yumemi.features.tutorial.TutorialNavigator

class TutorialNavigation: TutorialNavigator {
    override lateinit var navController: NavController

    override fun workList() {
        navController.navigate(TutorialFragmentDirections.actionTutorialToWorkList())
    }
}
