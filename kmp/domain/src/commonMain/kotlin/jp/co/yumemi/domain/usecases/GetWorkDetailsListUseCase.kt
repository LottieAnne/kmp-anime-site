package jp.co.yumemi.domain.usecases

import jp.co.yumemi.domain.core.UseCase
import jp.co.yumemi.domain.entities.WorkDetailsEntity
import jp.co.yumemi.domain.repositories.WorkDetailsListRepository

interface GetWorkDetailsListUseCase : UseCase<Unit, List<WorkDetailsEntity>>

class GetWorkDetailsListExecutor(
    private val workDetailsListRepository: WorkDetailsListRepository,
) : GetWorkDetailsListUseCase {
    override suspend fun execute(arguments: Unit): List<WorkDetailsEntity> =
        workDetailsListRepository.getWorkDetailsList()
}
