package home.vzhilko.github.feature.main.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import home.vzhilko.domain.feature.main.entity.RepositoryEntity
import home.vzhilko.github.R
import home.vzhilko.github.base.view.fragment.DaggerBaseFragment
import home.vzhilko.github.base.viewmodel.AppViewModel
import home.vzhilko.github.base.viewmodel.ViewModelFactory
import home.vzhilko.github.databinding.FragmentMainBinding
import home.vzhilko.github.extension.injectViewModel
import home.vzhilko.github.feature.main.view.adapter.RepositoriesListAdapter
import home.vzhilko.github.feature.main.viewmodel.MainViewModel
import javax.inject.Inject

class MainFragment : DaggerBaseFragment(), OnBackPressedCallback {

    private lateinit var repositoriesListRecyclerView: RecyclerView

    private lateinit var repositoriesListAdapter: RepositoriesListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var mainViewModel: MainViewModel
    private var appViewModel: AppViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainViewModel = injectViewModel(viewModelFactory)
        appViewModel = activity?.injectViewModel(viewModelFactory)

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

        subscribeOnRepositoriesListLoading()
        getRepositoriesList()
    }

    override fun handleOnBackPressed(): Boolean {
        appViewModel?.signOut()
        navController.popBackStack()
        return true
    }

    private fun subscribeOnRepositoriesListLoading() {
        mainViewModel.repositoriesListLiveData.observe(viewLifecycleOwner, Observer {
            repositoriesListAdapter.updateList(it)
        })
    }

    private fun getRepositoriesList() {
        mainViewModel.getRepositoriesList()
    }

}