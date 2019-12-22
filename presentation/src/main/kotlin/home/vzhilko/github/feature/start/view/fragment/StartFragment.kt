package home.vzhilko.github.feature.start.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import home.vzhilko.github.R
import home.vzhilko.github.base.view.fragment.DaggerBaseFragment
import home.vzhilko.github.base.viewmodel.ViewModelFactory
import home.vzhilko.github.databinding.FragmentStartBinding
import home.vzhilko.github.extension.injectViewModel
import home.vzhilko.github.feature.start.viewmodel.StartViewModel
import javax.inject.Inject

class StartFragment : DaggerBaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: StartViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = injectViewModel(viewModelFactory)
        val binding: FragmentStartBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        subscribeOnAuthorizationStepTransitionLoading()
    }

    //region Subscriptions to LiveDatas
    private val authorizationStepTransitionObserver = Observer<Unit?> { response ->
        response?.let { navController.navigate(R.id.auth_fragment) }
    }

    private fun subscribeOnAuthorizationStepTransitionLoading() {
        viewModel.authorizationStepTransitionLiveData.observe(
            viewLifecycleOwner,
            authorizationStepTransitionObserver
        )
    }
    //endregion

}