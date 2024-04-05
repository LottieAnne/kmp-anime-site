package jp.co.yumemi.features.tutorial

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.tutorial.TutorialStateMachine

@Module
@InstallIn(ActivityRetainedComponent::class)
class TutorialModule {
    @Provides
    fun provideTutorialStateMachine(): TutorialStateMachine = TutorialStateMachine()
}

