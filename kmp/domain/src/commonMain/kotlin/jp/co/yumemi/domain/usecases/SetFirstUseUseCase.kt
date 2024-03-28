package jp.co.yumemi.domain.usecases

import jp.co.yumemi.domain.core.UseCase
import jp.co.yumemi.domain.repositories.SplashRepository

interface SetFirstUseUseCase : UseCase<Unit, Unit>

class SetFirstUseExecutor(
    private val splashRepository: SplashRepository,
) : SetFirstUseUseCase {
    override suspend fun execute(arguments: Unit) {
        splashRepository.updateIsFirstUse()
    }
}
