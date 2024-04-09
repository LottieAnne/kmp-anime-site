package jp.co.yumemi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.features.home.HomeNavigator
import jp.co.yumemi.features.sample.SampleNavigator
import jp.co.yumemi.features.splash.SplashNavigator
import jp.co.yumemi.features.tutorial.TutorialNavigator
import jp.co.yumemi.features.workDetails.WorkDetailsNavigator
import jp.co.yumemi.navigation.HomeNavigation
import jp.co.yumemi.navigation.SampleNavigation
import jp.co.yumemi.navigation.SplashNavigation
import jp.co.yumemi.navigation.TutorialNavigation
import jp.co.yumemi.navigation.WorkDetailsNavigation

@Module
@InstallIn(ActivityRetainedComponent::class)
class NavigationModule {
    @Provides
    fun provideSampleNavigator(): SampleNavigator = SampleNavigation()

    @Provides
    fun provideSplashNavigator(): SplashNavigator = SplashNavigation()

    @Provides
    fun provideTutorialNavigator(): TutorialNavigator = TutorialNavigation()

    @Provides
    fun provideHomeNavigator(): HomeNavigator = HomeNavigation()

    @Provides
    fun provideWorkDetailsNavigator(): WorkDetailsNavigator = WorkDetailsNavigation()
}
