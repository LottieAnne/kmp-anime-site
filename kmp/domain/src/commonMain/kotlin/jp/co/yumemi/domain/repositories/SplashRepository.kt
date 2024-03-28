package jp.co.yumemi.domain.repositories

interface SplashRepository {
    suspend fun getIsFirstUse(): Boolean
    suspend fun updateIsFirstUse()
}
