package home.vzhilko.core.presentation.view.dialog

import android.app.Dialog
import home.vzhilko.core.domain.entity.MessageEntity

open class BaseDialogModel(val message: MessageEntity, val confirmationButtonText: String) {
    var cancelButtonText: String? = null
    var isCancelButtonShown: Boolean = false
    var onConfirmationButtonClickAction: ((Dialog?) -> Unit)? = null
    var onCancelButtonClickAction: ((Dialog?) -> Unit)? = null
}