package jp.co.yumemi.domain.usecases

import jp.co.yumemi.domain.core.UseCase
import jp.co.yumemi.domain.entities.WorkDetailsEntity
import jp.co.yumemi.domain.repositories.WorkDetailsRepository

interface GetWorkDetailsListUseCase : UseCase<Unit, List<WorkDetailsEntity>>

class GetWorkDetailsListExecutor(
    private val workDetailsListRepository: WorkDetailsRepository,
) : GetWorkDetailsListUseCase {
    override suspend fun execute(arguments: Unit): List<WorkDetailsEntity> = workDetailsListRepository.getWorkDetails()
}
