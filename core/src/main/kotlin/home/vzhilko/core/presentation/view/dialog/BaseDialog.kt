package home.vzhilko.core.presentation.view.dialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import home.vzhilko.core.R
import home.vzhilko.core.base.extension.logDebug
import home.vzhilko.core.presentation.viewmodel.AppViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

open class BaseDialog : DialogFragment() {

    protected lateinit var titleTextView: AppCompatTextView
    protected lateinit var confirmationButton: AppCompatButton
    protected lateinit var cancelButton: AppCompatButton

    private val appViewModel: AppViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        subscribeOnDialogModelLoading()
    }

    private fun subscribeOnDialogModelLoading() {
        appViewModel.dialogModelLiveData.observe(
            viewLifecycleOwner,
            Observer { model ->
                initViewsOnDialogModelLoading(model)
            }
        )
    }

    protected open fun initViewsOnDialogModelLoading(model: BaseDialogModel) {
        titleTextView.text = model.message.title

        confirmationButton.apply {
            text = model.confirmationButtonText
            setOnClickListener {
                model.onConfirmationButtonClickAction?.invoke(dialog) ?: dialog?.dismiss()
            }
        }

        cancelButton.apply {
            text = model.cancelButtonText
            visibility = if (model.isCancelButtonShown) View.VISIBLE else View.GONE
            setOnClickListener {
                model.onCancelButtonClickAction?.invoke(dialog) ?: dialog?.cancel()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        dialog?.let {
            it.window?.setLayout(
                resources.getDimensionPixelSize(R.dimen.github_dialog_width_default),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        "BaseDialog onDismiss dialog: ${dialog}".logDebug()
        super.onDismiss(dialog)
    }

}