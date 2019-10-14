package home.vzhilko.github.extension

import android.util.Log

const val LOG_TAG: String = "myTag"

fun String.logDebug() {
    Log.d(LOG_TAG, this)
}
