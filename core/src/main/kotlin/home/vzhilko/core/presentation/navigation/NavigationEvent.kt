package home.vzhilko.core.presentation.navigation

import android.os.Bundle

class NavigationEvent(val destinationId: Int, val arguments: Bundle? = null) {

    companion object {
        const val RETURN_BACK_EVENT_ID: Int = -1
    }

}