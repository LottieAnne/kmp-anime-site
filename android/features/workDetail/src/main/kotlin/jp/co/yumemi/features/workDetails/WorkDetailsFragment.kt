package jp.co.yumemi.features.workDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.core.foundation.contract
import jp.co.yumemi.core.utils.composeView

@AndroidEntryPoint
class WorkDetailsFragment : Fragment() {
    private val viewModel: WorkDetailsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = composeView {
        WorkDetailsScreenRoot(contract = contract(store = viewModel.store))
    }
}
