package home.vzhilko.github.base.view.fragment

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

abstract class BaseFragment : Fragment() {

    protected val navController: NavController by lazy {
        findNavController()
    }

}