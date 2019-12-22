package home.vzhilko.github.feature.main.view.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.setPadding
import home.vzhilko.domain.feature.main.entity.RepositoryEntity
import home.vzhilko.github.R
import home.vzhilko.github.databinding.ViewRepositoryWidgetBinding

class RepositoryWidgetView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var binding: ViewRepositoryWidgetBinding

    var content: RepositoryEntity? = null
        set(value) {
            field = value
            binding.content = field
        }

    init {
        init()
    }

    private fun init() {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        binding = ViewRepositoryWidgetBinding.inflate(inflater, this, true)
        setPadding(resources.getDimension(R.dimen.github_content_margin_default).toInt())
    }

}