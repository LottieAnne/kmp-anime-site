package jp.co.yumemi.navigation

import androidx.navigation.NavController
import jp.co.yumemi.features.workDetails.WorkDetailsNavigator

class WorkDetailsNavigation : WorkDetailsNavigator {
    override lateinit var navController: NavController

    override fun back() {
        navController.navigateUp()
    }
}
