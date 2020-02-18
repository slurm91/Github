package home.vzhilko.auth.presentation.view.fragment

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
import home.vzhilko.auth.R
import home.vzhilko.auth.databinding.FragmentAuthorizationBinding
import home.vzhilko.core.presentation.view.fragment.BaseFragment
import home.vzhilko.auth.presentation.viewmodel.AuthorizationViewModel
import home.vzhilko.core.domain.network.OAUTH_AUTHORIZATION_URL
import home.vzhilko.core.presentation.navigation.navigateToMainScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthorizationFragment : BaseFragment(), OnBackPressedCallback {

    private lateinit var webView: WebView

    private val viewModel: AuthorizationViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAuthorizationBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_authorization,
                container,
                false
            )
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
        requireActivity().addOnBackPressedCallback(viewLifecycleOwner, this)
        initWebView()
        subscribeOnProgressLiveData()
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
    private fun subscribeOnProgressLiveData() {
        viewModel.progressLiveData.observe(viewLifecycleOwner, Observer { response ->
            isProgressShown = response
        })
    }

    private fun subscribeOnAuthorizationLiveData() {
        viewModel.authorizationLiveData.observe(viewLifecycleOwner, Observer { response ->
            navController.popBackStack()
            activity?.let { fragmentActivity ->
                navigateToMainScreen(fragmentActivity, navController)
            }
        })
    }
    //endregion

}