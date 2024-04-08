package jp.co.yumemi.features.home

import jp.co.yumemi.core.foundation.Navigator
import jp.co.yumemi.domain.entities.WorkEntity

interface HomeNavigator: Navigator {
    fun workDetails(work: WorkEntity)
}
