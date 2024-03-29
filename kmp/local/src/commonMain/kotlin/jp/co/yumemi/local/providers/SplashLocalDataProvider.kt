package jp.co.yumemi.local.providers

import com.russhwolf.settings.Settings
import jp.co.yumemi.data.core.runHandling
import jp.co.yumemi.data.sources.SplashLocalDataSource
import jp.co.yumemi.local.core.LocalExceptionHandler
import jp.co.yumemi.local.core.getOrNull
import jp.co.yumemi.local.core.set
import jp.co.yumemi.local.settings.SettingKeys

class SplashLocalDataProvider(
    private val settings: Settings,
    private val exceptionHandler: LocalExceptionHandler,
) : SplashLocalDataSource {
    override suspend fun getIsFirstUse(): Boolean = runHandling(exceptionHandler) {
        settings.getOrNull(SettingKeys.IsFirstUse) ?: true
    }

    override suspend fun setIsFirstUse() {
       settings[SettingKeys.IsFirstUse] = false
    }
}
