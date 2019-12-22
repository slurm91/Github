package home.vzhilko.github.feature.auth.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import home.vzhilko.domain.base.network.OAUTH_AUTHORIZATION_URL
import home.vzhilko.github.R
import home.vzhilko.github.base.view.fragment.DaggerBaseFragment
import home.vzhilko.github.databinding.FragmentAuthorizationBinding
import home.vzhilko.github.extension.injectViewModel
import home.vzhilko.github.feature.auth.viewmodel.AuthorizationViewModel
import javax.inject.Inject

class AuthorizationFragment : DaggerBaseFragment(), OnBackPressedCallback {

    private lateinit var webView: WebView

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: AuthorizationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = injectViewModel(viewModelFactory)
        val binding: FragmentAuthorizationBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_authorization, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        webView = binding.authWebView

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        viewModel = injectViewModel(viewModelFactory)
        requireActivity().addOnBackPressedCallback(viewLifecycleOwner, this)
        initWebView()
        subscribeOnAuthorizationLiveData()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        webView.apply {
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    viewModel.authorize(request?.url)
                    return false
                }
            }

            loadUrl(OAUTH_AUTHORIZATION_URL)
        }
    }

    override fun handleOnBackPressed(): Boolean {
        val canGoBack: Boolean = webView.canGoBack()
        if (canGoBack) webView.goBack()

        return canGoBack
    }

    //region Subscriptions to LiveDatas
    private fun subscribeOnAuthorizationLiveData() {
        viewModel.authorizationLiveData.observe(viewLifecycleOwner, Observer { response ->
            response?.let {
                navController.popBackStack()
                navController.navigate(R.id.auth_graph)
            }
        })
    }
    //endregion

}