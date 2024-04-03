package jp.co.yumemi.domain.usecases

import jp.co.yumemi.domain.core.UseCase
import jp.co.yumemi.domain.entities.WorkEpisodeEntity
import jp.co.yumemi.domain.repositories.WorkEpisodeListRepository

interface GetWorkEpisodeListUseCase : UseCase<Unit, List<WorkEpisodeEntity>>

class GetWorkEpisodeListExecutor(
    private val workEpisodeListRepository: WorkEpisodeListRepository,
) : GetWorkEpisodeListUseCase {
    override suspend fun execute(arguments: Unit): List<WorkEpisodeEntity> =
        workEpisodeListRepository.getWorkEpisodeList()
}