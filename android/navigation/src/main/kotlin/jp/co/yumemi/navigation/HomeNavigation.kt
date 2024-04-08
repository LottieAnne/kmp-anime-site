package jp.co.yumemi.navigation

import androidx.navigation.NavController
import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.features.home.HomeNavigator

class HomeNavigation : HomeNavigator {
    override lateinit var navController: NavController

    override fun workDetails(work: WorkEntity) {
        navController.navigate(
            directions = AppNavGraphDirections.actionFromWorkListToWorkDetails(
                work = work
            )
        )
    }
}
