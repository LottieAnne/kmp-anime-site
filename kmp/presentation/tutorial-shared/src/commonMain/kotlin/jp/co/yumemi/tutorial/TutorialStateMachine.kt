package jp.co.yumemi.tutorial

import tech.fika.macaron.statemachine.components.StateMachine
import tech.fika.macaron.statemachine.components.event

class TutorialStateMachine :
    StateMachine<TutorialIntent, TutorialAction, TutorialResult, TutorialState, TutorialEvent>(
        builder = {
            state<TutorialState.Stable> {
                interpret<TutorialIntent.ClickStart> { TutorialAction.NavigateList }
                process<TutorialAction> { event(TutorialEvent.NavigateList) }
            }
        }
    )
