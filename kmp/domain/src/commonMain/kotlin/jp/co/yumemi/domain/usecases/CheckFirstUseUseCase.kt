package jp.co.yumemi.domain.usecases

import jp.co.yumemi.domain.core.UseCase
import jp.co.yumemi.domain.repositories.SplashRepository

interface CheckFirstUseUseCase : UseCase<Unit, Boolean>

class CheckFirstUseExecutor(
    private val splashRepository: SplashRepository,
) : CheckFirstUseUseCase {
    override suspend fun execute(arguments: Unit): Boolean {
        return splashRepository.getIsFirstUse()
    }
}
