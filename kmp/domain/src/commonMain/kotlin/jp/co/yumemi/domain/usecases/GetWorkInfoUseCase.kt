package jp.co.yumemi.domain.usecases

import jp.co.yumemi.domain.core.UseCase
import jp.co.yumemi.domain.entities.WorkInfoEntity
import jp.co.yumemi.domain.repositories.WorkDetailsRepository

interface GetWorkInfoUseCase : UseCase<Unit, WorkInfoEntity>

class GetWorkInfoExecutor(
    private val workInfoRepository: WorkDetailsRepository,
) : GetWorkInfoUseCase {
    override suspend fun execute(arguments: Unit): WorkInfoEntity = workInfoRepository.getWorkInfo()
}
