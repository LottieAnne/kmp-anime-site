package jp.co.yumemi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.features.sample.SampleNavigator
import jp.co.yumemi.features.splash.SplashNavigator
import jp.co.yumemi.navigation.SampleNavigation
import jp.co.yumemi.navigation.SplashNavigation

@Module
@InstallIn(ActivityRetainedComponent::class)
class NavigationModule {
    @Provides
    fun provideSampleNavigator(): SampleNavigator = SampleNavigation()

    @Provides
    fun provideSplashNavigator(): SplashNavigator = SplashNavigation()
}
