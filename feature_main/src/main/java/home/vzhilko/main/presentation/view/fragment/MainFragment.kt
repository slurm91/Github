package home.vzhilko.main.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import home.vzhilko.core.presentation.view.fragment.BaseFragment
import home.vzhilko.core.presentation.viewmodel.AppViewModel
import home.vzhilko.main.presentation.view.adapter.RepositoriesListAdapter
import home.vzhilko.main.presentation.viewmodel.MainViewModel
import home.vzhilko.main.R
import home.vzhilko.main.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment(), OnBackPressedCallback {

    private lateinit var repositoriesListRecyclerView: RecyclerView

    private lateinit var repositoriesListAdapter: RepositoriesListAdapter

    private val mainViewModel: MainViewModel by viewModel()
    private val appViewModel: AppViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMainBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        repositoriesListRecyclerView = binding.mainRepositoriesListRecyclerView

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        requireActivity().addOnBackPressedCallback(viewLifecycleOwner, this)
        repositoriesListAdapter = RepositoriesListAdapter()
        repositoriesListRecyclerView.setHasFixedSize(true)
        repositoriesListRecyclerView.adapter = repositoriesListAdapter

        subscribeOnProgressLiveData()
        subscribeOnRepositoriesListLoading()
        getRepositoriesList()
    }

    override fun handleOnBackPressed(): Boolean {
        appViewModel.signOut()
        navController.popBackStack()
        return true
    }

    //region Subscriptions to LiveDatas
    private fun subscribeOnProgressLiveData() {
        mainViewModel.progressLiveData.observe(viewLifecycleOwner, Observer { response ->
            isProgressShown = response
        })
    }

    private fun subscribeOnRepositoriesListLoading() {
        mainViewModel.repositoriesListLiveData.observe(viewLifecycleOwner, Observer {
            repositoriesListAdapter.updateList(it)
        })
    }

    private fun getRepositoriesList() {
        mainViewModel.getRepositoriesList()
    }
    //endregion

}