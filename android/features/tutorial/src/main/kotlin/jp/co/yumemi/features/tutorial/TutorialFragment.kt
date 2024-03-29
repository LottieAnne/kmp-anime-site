package jp.co.yumemi.features.tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.core.foundation.contract
import jp.co.yumemi.core.foundation.setNavController
import jp.co.yumemi.core.utils.composeView
import javax.inject.Inject

@AndroidEntryPoint
class TutorialFragment: Fragment() {
    @Inject
    lateinit var navigator: TutorialNavigator

    private val viewModel: TutorialViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = composeView {
        TutorialScreenRoot(
            contract = contract(store = viewModel.store),
            navigator = navigator.setNavController(),
        )
    }
}
