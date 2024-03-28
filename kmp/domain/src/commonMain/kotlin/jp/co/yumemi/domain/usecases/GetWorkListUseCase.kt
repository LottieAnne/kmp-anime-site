package jp.co.yumemi.domain.usecases

import jp.co.yumemi.domain.core.UseCase
import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.domain.repositories.WorkListRepository

interface GetWorkListUseCase : UseCase<Unit, List<WorkEntity>>

class GetWorkListExecutor(
    private val workListRepository: WorkListRepository,
) : GetWorkListUseCase {
    override suspend fun execute(arguments: Unit): List<WorkEntity> = workListRepository.getWorkList()
}
