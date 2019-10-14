package home.vzhilko.github.feature.test.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import home.vzhilko.github.feature.test.model.TestListItemModel
import home.vzhilko.github.feature.test.view.component.TestListItemView

class TestListAdapter(private val onItemClickAction: (TestListItemModel) -> Unit)
    : RecyclerView.Adapter<TestListItemViewHolder>() {

    private var list: List<TestListItemModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestListItemViewHolder {
        val view = TestListItemView(parent.context)
        return TestListItemViewHolder(view, onItemClickAction)
    }

    override fun onBindViewHolder(holder: TestListItemViewHolder, position: Int) {
        holder.populate(list[position])
    }

    override fun getItemCount() = list.size

    fun updateList(list: List<TestListItemModel>) {
        this.list = list
        notifyDataSetChanged()
    }

}