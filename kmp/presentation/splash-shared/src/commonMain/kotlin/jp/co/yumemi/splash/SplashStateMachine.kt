package jp.co.yumemi.splash

import jp.co.yumemi.domain.core.execute
import jp.co.yumemi.domain.usecases.CheckFirstUseUseCase
import jp.co.yumemi.domain.usecases.SetFirstUseUseCase
import kotlinx.coroutines.delay
import tech.fika.macaron.statemachine.components.StateMachine
import tech.fika.macaron.statemachine.components.event

class SplashStateMachine(
    private val checkFirstUseUseCase: CheckFirstUseUseCase,
    private val setFirstUseUseCase: SetFirstUseUseCase
) : StateMachine<
        SplashIntent, SplashAction, SplashResult, SplashState, SplashEvent>(
    builder = {
        state<SplashState.Stable> {
            interpret<SplashIntent.OnStart> { SplashAction.CheckFirstUse }
            process<SplashAction.CheckFirstUse> {
                delay(3000)
                val isFirstUse = runCatching { checkFirstUseUseCase.execute() }.getOrDefault(true)
                if (isFirstUse) {
                    runCatching { setFirstUseUseCase.execute() }
                    event(SplashEvent.NavigateTutorial)
                } else {
                    event(SplashEvent.NavigateWorkList)
                }
            }
        }
    }
)
