package jp.co.yumemi.features.next

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.core.utils.composeView

@AndroidEntryPoint
class NextFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = composeView {
        SampleNextScreenRoot()
    }
}
