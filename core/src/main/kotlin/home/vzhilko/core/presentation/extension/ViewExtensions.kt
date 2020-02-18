package home.vzhilko.core.presentation.extension

import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun View.getColorById(@ColorRes id: Int): Int {
    return ContextCompat.getColor(context, id)
}