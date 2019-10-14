package home.vzhilko.github.feature.test.view.component

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatTextView
import home.vzhilko.github.R
import home.vzhilko.github.feature.test.model.TestListItemModel

class TestListItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var titleTextView: AppCompatTextView
    private var descriptionTextView: AppCompatTextView
    private var checkBox: AppCompatCheckBox

    var content: TestListItemModel? = null
    set(value) {
        field = value
        titleTextView.text = field?.title
        descriptionTextView.text = field?.description
        checkBox.isSelected = field?.isSelected ?: false
    }

    init {
        View.inflate(context, R.layout.view_test_list_item, this)
        titleTextView = findViewById(R.id.test_list_item_title_tv)
        descriptionTextView = findViewById(R.id.test_list_item_description_tv)
        checkBox = findViewById(R.id.test_list_item_checkbox)
    }

}