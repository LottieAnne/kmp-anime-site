package jp.co.yumemi.domain.usecases

import jp.co.yumemi.domain.core.UseCase
import jp.co.yumemi.domain.entities.WorkEpisodeEntity
import jp.co.yumemi.domain.repositories.WorkDetailsRepository

interface GetWorkEpisodeListUseCase :
    UseCase<GetWorkEpisodeListUseCase.Args, List<WorkEpisodeEntity>> {
    data class Args(val id: Int)
}

class GetWorkEpisodeListExecutor(
    private val workEpisodeListRepository: WorkDetailsRepository,
) : GetWorkEpisodeListUseCase {
    override suspend fun execute(arguments: GetWorkEpisodeListUseCase.Args): List<WorkEpisodeEntity> =
        workEpisodeListRepository.getWorkEpisodeList(id = arguments.id)
}
