package home.vzhilko.start.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import home.vzhilko.core.presentation.navigation.navigateToAuthorizationScreen
import home.vzhilko.core.presentation.view.fragment.BaseFragment
import home.vzhilko.start.R
import home.vzhilko.start.databinding.FragmentStartBinding
import home.vzhilko.start.presentation.viewmodel.StartViewModel
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
                //response?.let { navController.navigate(R.id.auth_fragment) }
                response?.let {
                    activity?.let { fragmentActivity ->
                        navigateToAuthorizationScreen(fragmentActivity, navController)
                    }
                }
            }
        )
    }

    private fun subscribeOnRegistrationStepTransitionLoading() {
        this.startViewModel.registrationStepTransitionLiveData.observe(
            viewLifecycleOwner,
            Observer { response ->
                //response?.let { navController.navigate(R.id.test_graph) }
            }
        )
    }
    //endregion

}