package jp.co.yumemi.features.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.core.foundation.setNavController
import jp.co.yumemi.core.utils.composeView
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : Fragment() {

    @Inject
    lateinit var navigator: SplashNavigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = composeView {
        SplashScreenRoot(
            navigator = navigator.setNavController(),
        )
    }
}
