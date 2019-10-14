package home.vzhilko.github.feature.start.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import home.vzhilko.github.R
import home.vzhilko.github.base.model.UserModel
import home.vzhilko.github.base.view.fragment.DaggerBaseFragment
import home.vzhilko.github.base.viewmodel.ViewModelFactory
import home.vzhilko.github.extension.injectViewModel
import home.vzhilko.github.feature.start.viewmodel.StartViewModel
import javax.inject.Inject
import javax.inject.Named

class StartFragment : DaggerBaseFragment() {

    private lateinit var goToTestButton: AppCompatButton

    @Inject
    @field: Named("StartFragment")
    lateinit var user: UserModel

    @Inject
    lateinit var factory: ViewModelFactory
    lateinit var viewModel: StartViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        //"StartFragment factory $factory viewModel $viewModel".logDebug()
        //"StartFragment user ref $user".logDebug()
    }

    private fun init() {
        viewModel = injectViewModel(factory)
        goToTestButton = view?.findViewById(R.id.fragment_start_go_to_test_btn)!!
        goToTestButton.setOnClickListener {
            //"StartFragment onClick nav: $navController".logDebug()
            //navController.navigate(R.id.test_fragment)
            navController.navigate(R.id.auth_graph)
        }
    }

}