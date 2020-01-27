package home.vzhilko.github.feature.start.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import home.vzhilko.github.R
import home.vzhilko.github.base.view.fragment.BaseFragment
import home.vzhilko.github.databinding.FragmentStartBinding
import home.vzhilko.github.feature.start.viewmodel.StartViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class StartFragment : BaseFragment() {

    private val startViewModel: StartViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentStartBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = this.startViewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        subscribeOnAuthorizationStepTransitionLoading()
        subscribeOnRegistrationStepTransitionLoading()
    }

    //region Subscriptions to LiveDatas
    private fun subscribeOnAuthorizationStepTransitionLoading() {
        this.startViewModel.authorizationStepTransitionLiveData.observe(
            viewLifecycleOwner,
            Observer { response ->
                response?.let { navController.navigate(R.id.auth_fragment) }
            }
        )
    }

    private fun subscribeOnRegistrationStepTransitionLoading() {
        this.startViewModel.registrationStepTransitionLiveData.observe(
            viewLifecycleOwner,
            Observer { response ->
                response?.let { navController.navigate(R.id.test_graph) }
            }
        )
    }
    //endregion

}