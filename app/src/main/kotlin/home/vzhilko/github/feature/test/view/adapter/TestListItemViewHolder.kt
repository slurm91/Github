package home.vzhilko.github.feature.test.view.adapter

import androidx.recyclerview.widget.RecyclerView
import home.vzhilko.github.feature.test.model.TestListItemModel
import home.vzhilko.github.feature.test.view.component.TestListItemView

class TestListItemViewHolder(
    itemView: TestListItemView,
    private val onItemClickAction: (TestListItemModel) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private lateinit var content: TestListItemModel

    init {
        itemView.setOnClickListener { onItemClickAction(content) }
    }

    fun populate(content: TestListItemModel) {
        this.content = content
        if (itemView is TestListItemView) {
            itemView.content = this.content
        }
    }

}