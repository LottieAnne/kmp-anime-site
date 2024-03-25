package jp.co.yumemi.domain.usecases

import jp.co.yumemi.domain.core.UseCase
import jp.co.yumemi.domain.entities.HomeEntity
import jp.co.yumemi.domain.repositories.HomeRepository

interface HomeUseCase : UseCase<HomeUseCase.Args, List<HomeEntity>> {
    data class Args(val id: Int)
}

class HomeExecutor(
    private val homeRepository: HomeRepository,
) : HomeUseCase {
    override suspend fun execute(arguments: HomeUseCase.Args): List<HomeEntity> = homeRepository.getHomeWorkList(id = arguments.id)
}
