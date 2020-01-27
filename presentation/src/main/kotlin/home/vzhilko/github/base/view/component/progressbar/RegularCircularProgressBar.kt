package home.vzhilko.github.base.view.component.progressbar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import home.vzhilko.github.R
import home.vzhilko.github.databinding.ViewProgressBarRegularCircularBinding
import home.vzhilko.github.extension.getColorById

class RegularCircularProgressBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), IProgressBar {

    private lateinit var binding: ViewProgressBarRegularCircularBinding

    init {
        init()
    }

    private fun init() {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        binding = ViewProgressBarRegularCircularBinding.inflate(inflater, this, true)
        hideProgress()
        isClickable = true
        setBackgroundColor(getColorById(R.color.black_50))
    }

    override fun showProgress() {
        visibility = View.VISIBLE
    }

    override fun hideProgress() {
        visibility = View.GONE
    }

}