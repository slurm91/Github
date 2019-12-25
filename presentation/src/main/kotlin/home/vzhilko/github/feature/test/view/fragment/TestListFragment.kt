package home.vzhilko.github.feature.test.view.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.addTextChangedListener
import androidx.databinding.BindingAdapter
import androidx.databinding.adapters.TextViewBindingAdapter
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import home.vzhilko.github.R
import home.vzhilko.github.base.view.fragment.DaggerBaseFragment
import home.vzhilko.github.base.viewmodel.ViewModelFactory
import home.vzhilko.github.databinding.FragmentTestListBinding
import home.vzhilko.github.extension.injectViewModel
import home.vzhilko.github.feature.test.view.adapter.TestListAdapter
import home.vzhilko.github.feature.test.view.component.TestListItemView
import home.vzhilko.github.feature.test.viewmodel.TestListViewModel
import javax.inject.Inject

//@BindingAdapter(value = ["android:text"])
fun setFullName(textView: AppCompatTextView, oldFullName: String?, newFullName: String?) {
    Log.d(
        "myTag", "BindingAdapter text oldFullName: ${oldFullName}" +
                " newFullName: ${newFullName}"
    )
    if (newFullName != oldFullName) {
        textView.text = " '$'$newFullName'$' "
    }
}

class TestListFragment : DaggerBaseFragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var testListItemView: TestListItemView

    private lateinit var adapter: TestListAdapter

    @Inject
    lateinit var factory: ViewModelFactory
    lateinit var viewModel: TestListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return initDataBinding(inflater, container, savedInstanceState)
    }

    private fun initDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = injectViewModel(factory)
        val binding: FragmentTestListBinding = FragmentTestListBinding.inflate(inflater, container, false)
        binding.apply {
            lifecycleOwner = this@TestListFragment.viewLifecycleOwner
            viewModel = this@TestListFragment.viewModel
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }

    private fun init(rootView: View) {
        testListItemView = rootView.findViewById(R.id.test_list_item_view)

        //Recycler view init
        initRecyclerView(rootView)
    }

    private fun initRecyclerView(rootView: View) {
        recyclerView = rootView.findViewById(R.id.test_list_recycler_view)
        adapter = TestListAdapter { testListItemView.content = it }
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        subscribeOnListUpdate()
        viewModel.updateList()
    }

    private fun subscribeOnListUpdate() {
        viewModel.testListLiveData.observe(viewLifecycleOwner, Observer { list ->
            list?.let { adapter.updateList(it) }
        })
    }

}