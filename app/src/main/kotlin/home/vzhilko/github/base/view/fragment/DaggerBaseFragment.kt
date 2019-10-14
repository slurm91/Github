package home.vzhilko.github.base.view.fragment

import android.content.Context
import dagger.android.support.AndroidSupportInjection

abstract class DaggerBaseFragment : BaseFragment() {

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

}