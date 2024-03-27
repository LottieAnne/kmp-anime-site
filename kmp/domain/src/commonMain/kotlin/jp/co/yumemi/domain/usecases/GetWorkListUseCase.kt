package jp.co.yumemi.domain.usecases

import jp.co.yumemi.domain.core.UseCase
import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.domain.repositories.WorkRepository

interface GetWorkListUseCase : UseCase<Unit, List<WorkEntity>>

class GetWorkListExecutor(
    private val workRepository: WorkRepository,
) : GetWorkListUseCase {
    override suspend fun execute(arguments: Unit): List<WorkEntity> = workRepository.getWorkList()
}
