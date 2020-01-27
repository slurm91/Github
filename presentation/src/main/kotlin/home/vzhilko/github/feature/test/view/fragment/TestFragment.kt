package home.vzhilko.github.feature.test.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.*
import home.vzhilko.github.R
import home.vzhilko.github.base.model.UserObservableModel
import home.vzhilko.github.base.view.fragment.BaseFragment
import home.vzhilko.github.feature.test.viewmodel.TestViewModel
import home.vzhilko.github.databinding.FragmentTestBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TestFragment : BaseFragment() {

    private lateinit var goToStartButton: AppCompatButton

    private val viewModel: TestViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return bind(inflater, container)
    }

    private fun bind(inflater: LayoutInflater, container: ViewGroup?): View? {
        val binding: FragmentTestBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)
        //"TestFragment bind user ${user.login}".logDebug()
        binding.observableUser = UserObservableModel("test1", "1111")
        binding.fragment = this
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        //"TestFragment factory $factory viewModel $viewModel".logDebug()
        //"TestFragment user ref $user".logDebug()
    }

    private fun init() {
        goToStartButton = view?.findViewById(R.id.fragment_test_go_to_start_btn)!!
        goToStartButton.setOnClickListener {
            //"TestFragment onClick nav: $navController".logDebug()
            navController.popBackStack()
        }
    }

    fun onTestClick(view: View, userModel: UserObservableModel) {
        userModel.login = "test2"
        Toast.makeText(context, view.javaClass.simpleName, Toast.LENGTH_SHORT).show()
    }

    companion object {
        /*@JvmStatic
        @BindingAdapter("android:text")
        fun setCustomText(view: AppCompatTextView, oldText: String?, newText: String?) {
            "TestFragment setCustomText old text: $oldText new text: $newText".logDebug()
        }*/

        /*@BindingAdapter("login")
        @JvmStatic
        fun setLogin(editText: AppCompatEditText, login: LiveData<String>) {
            "TestFragment BindingAdapter setLogin text: ${login.value}".logDebug()
            editText.text = Editable.Factory.getInstance().newEditable(login.value)
        }*/

        /*@BindingAdapter("login")
        @JvmStatic
        fun setLogin(editText: AppCompatEditText, login: String) {
            "TestFragment BindingAdapter setLogin text: ${login}".logDebug()
            editText.text = Editable.Factory.getInstance().newEditable(login)
        }*/

        /*@InverseBindingAdapter(attribute = "login", event = "loginAttrChanged")
        @JvmStatic
        fun getLogin(editText: AppCompatEditText): String {
            "TestFragment InverseBindingAdapter getLogin text: ${editText.text}".logDebug()
            return editText.text?.toString() ?: ""
        }*/

        /*@JvmStatic
        @BindingAdapter("loginAttrChanged")
        fun setLoginListeners(editText: AppCompatEditText, listener: InverseBindingListener) {

        }*/


        /*@BindingConversion
        fun getLoginFromUserModel(userModel: MutableLiveData<UserModel>): String {
            return userModel.value?.login ?: ""
        }*/
    }

    class EditTextInverseBindingListener : InverseBindingListener {
        override fun onChange() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

}