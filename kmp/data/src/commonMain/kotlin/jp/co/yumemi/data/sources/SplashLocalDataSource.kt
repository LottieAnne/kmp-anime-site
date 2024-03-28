package jp.co.yumemi.data.sources

interface SplashLocalDataSource {
    suspend fun getIsFirstUse(): Boolean
    suspend fun setIsFirstUse()
}
