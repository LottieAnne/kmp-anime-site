package jp.co.yumemi.domain.usecases

import jp.co.yumemi.domain.core.UseCase
import jp.co.yumemi.domain.entities.WorkEpisodeEntity
import jp.co.yumemi.domain.repositories.WorkEpisodeRepository

interface GetWorkEpisodeListUseCase : UseCase<Unit, List<WorkEpisodeEntity>>

class GetWorkEpisodeListExecutor(
    private val workEpisodeRepository: WorkEpisodeRepository,
) : GetWorkEpisodeListUseCase {
    override suspend fun execute(arguments: Unit): List<WorkEpisodeEntity> = workEpisodeRepository.getWorkEpisodeList()
}
