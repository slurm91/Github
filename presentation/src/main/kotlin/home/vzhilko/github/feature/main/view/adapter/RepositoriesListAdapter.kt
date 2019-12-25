package home.vzhilko.github.feature.main.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import home.vzhilko.domain.feature.main.entity.RepositoryEntity
import home.vzhilko.github.feature.main.view.adapter.holder.RepositoriesListAdapterViewHolder
import home.vzhilko.github.feature.main.view.component.RepositoryWidgetView

class RepositoriesListAdapter : RecyclerView.Adapter<RepositoriesListAdapterViewHolder>() {

    private var list: List<RepositoryEntity> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepositoriesListAdapterViewHolder {
        val view = RepositoryWidgetView(parent.context)
        return RepositoriesListAdapterViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RepositoriesListAdapterViewHolder, position: Int) {
        holder.populate(list[position])
    }

    fun updateList(list: List<RepositoryEntity>) {
        this.list = list
        notifyDataSetChanged()
    }

}