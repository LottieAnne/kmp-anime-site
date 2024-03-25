package jp.co.yumemi.domain.usecases

import jp.co.yumemi.domain.core.UseCase
import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.domain.repositories.WorkRepository

interface HomeUseCase : UseCase<HomeUseCase.Args, List<WorkEntity>> {
    data class Args(val id: Int)
}

class HomeExecutor(
    private val workRepository: WorkRepository,
) : HomeUseCase {
    override suspend fun execute(arguments: HomeUseCase.Args): List<WorkEntity> = workRepository.getHomeWorkList(id = arguments.id)
}
