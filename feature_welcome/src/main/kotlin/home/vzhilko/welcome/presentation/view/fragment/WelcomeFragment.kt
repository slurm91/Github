package home.vzhilko.welcome.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import home.vzhilko.core.presentation.navigation.navigateToAuthorizationScreen
import home.vzhilko.core.presentation.view.fragment.BaseFragment
import home.vzhilko.welcome.R
import home.vzhilko.welcome.databinding.FragmentWelcomeBinding
import home.vzhilko.welcome.presentation.viewmodel.WelcomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WelcomeFragment : BaseFragment() {

    private val welcomeViewModel: WelcomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWelcomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = this.welcomeViewModel

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
        this.welcomeViewModel.authorizationStepTransitionLiveData.observe(
            viewLifecycleOwner,
            Observer { response ->
                response?.let {
                    activity?.let { fragmentActivity ->
                        navigateToAuthorizationScreen(fragmentActivity, navController)
                    }
                }
            }
        )
    }

    private fun subscribeOnRegistrationStepTransitionLoading() {
        this.welcomeViewModel.registrationStepTransitionLiveData.observe(
            viewLifecycleOwner,
            Observer { response ->
                //response?.let { navController.navigate(R.id.test_graph) }
            }
        )
    }
    //endregion

}