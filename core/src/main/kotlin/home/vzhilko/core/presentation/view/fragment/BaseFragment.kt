package home.vzhilko.core.presentation.view.fragment

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import home.vzhilko.core.presentation.view.activity.BaseActivity
import kotlin.reflect.KProperty

abstract class BaseFragment : Fragment() {

    protected val navController: NavController by lazy {
        findNavController()
    }

    protected var isProgressShown: Boolean by ProgressDelegate()

    protected fun getParentActivity(): BaseActivity? {
        return activity as? BaseActivity
    }

    private class ProgressDelegate {

        operator fun getValue(fragment: BaseFragment?, property: KProperty<*>): Boolean {
            return fragment?.getParentActivity()?.isProgressShown ?: false
        }

        operator fun setValue(fragment: BaseFragment?, property: KProperty<*>, value: Boolean) {
            fragment?.getParentActivity()?.isProgressShown = value
        }

    }

}