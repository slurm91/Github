package home.vzhilko.core.presentation.view.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import home.vzhilko.core.R
import home.vzhilko.core.databinding.DialogRegularBinding

class RegularDialog : BaseDialog() {

    companion object {
        fun newInstance(): RegularDialog {
            return RegularDialog()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: DialogRegularBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.dialog_regular,
                container,
                false
            )
        binding.lifecycleOwner = viewLifecycleOwner
        titleTextView = binding.regularAlertTitleTv
        confirmationButton = binding.regularAlertConfirmationBtn
        cancelButton = binding.regularAlertCancelBtn

        return binding.root
    }

}