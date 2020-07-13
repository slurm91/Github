package home.vzhilko.main.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import home.vzhilko.core.presentation.navigation.NavigationEvent
import home.vzhilko.core.presentation.view.fragment.BaseFragment
import home.vzhilko.main.presentation.view.adapter.RepositoriesListAdapter
import home.vzhilko.main.presentation.viewmodel.MainViewModel
import home.vzhilko.main.R
import home.vzhilko.main.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment() {

    private lateinit var repositoriesListRecyclerView: RecyclerView

    private lateinit var repositoriesListAdapter: RepositoriesListAdapter

    private val mainViewModel: MainViewModel by viewModel()

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
        requireActivity().onBackPressedDispatcher.addCallback(this, true) {
            mainViewModel.onBackPressed()
        }
        repositoriesListAdapter = RepositoriesListAdapter()
        repositoriesListRecyclerView.setHasFixedSize(true)
        repositoriesListRecyclerView.adapter = repositoriesListAdapter

        subscribeOnProgressLiveData()
        subscribeOnDialogModelLoading()
        subscribeOnRepositoriesListLoading()
        getRepositoriesList()
    }

    //region Subscriptions to LiveData
    private fun subscribeOnProgressLiveData() {
        mainViewModel.progressLiveData.observe(viewLifecycleOwner, Observer { response ->
            isProgressShown = response
        })
    }

    private fun subscribeOnDialogModelLoading() {
        mainViewModel.navigationEventLiveData.observe(viewLifecycleOwner, Observer { event ->
            if (event?.destinationId == NavigationEvent.RETURN_BACK_EVENT_ID) {
                appViewModel.signOut()
                navController.popBackStack(R.id.id_navigation_screen_main, true)
            }
        })

        mainViewModel.dialogModelSingleLiveData.observe(viewLifecycleOwner, Observer { model ->
            appViewModel.dialogModelLiveData.value = model
            navController.navigate(R.id.id_navigation_screen_dialog_regular)
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