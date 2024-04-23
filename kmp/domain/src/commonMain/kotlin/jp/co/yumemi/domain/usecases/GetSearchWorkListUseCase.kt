package jp.co.yumemi.domain.usecases

import jp.co.yumemi.domain.core.UseCase
import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.domain.repositories.WorkSearchListRepository

interface GetSearchWorkListUseCase : UseCase<GetSearchWorkListUseCase.Args, List<WorkEntity>> {
    data class Args(val title: String)
}

class GetSearchWorkListExecutor(
    private val workSearchListRepository: WorkSearchListRepository,
) : GetSearchWorkListUseCase {
    override suspend fun execute(arguments: GetSearchWorkListUseCase.Args): List<WorkEntity> =
        workSearchListRepository.getSearchWorkList(title = arguments.title)
}
