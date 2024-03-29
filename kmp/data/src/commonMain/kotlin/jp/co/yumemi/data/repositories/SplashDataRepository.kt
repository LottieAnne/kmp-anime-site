package jp.co.yumemi.data.repositories

import jp.co.yumemi.data.sources.SplashLocalDataSource
import jp.co.yumemi.domain.repositories.SplashRepository

class SplashDataRepository(
    private val splashLocalDataSource: SplashLocalDataSource
) : SplashRepository {
    override suspend fun getIsFirstUse(): Boolean {
        return splashLocalDataSource.getIsFirstUse()
    }

    override suspend fun updateIsFirstUse() {
        splashLocalDataSource.setIsFirstUse()
    }
}
