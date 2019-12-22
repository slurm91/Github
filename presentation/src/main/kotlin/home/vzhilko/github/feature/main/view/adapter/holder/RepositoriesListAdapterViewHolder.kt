package home.vzhilko.github.feature.main.view.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import home.vzhilko.domain.feature.main.entity.RepositoryEntity
import home.vzhilko.github.feature.main.view.component.RepositoryWidgetView

class RepositoriesListAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun populate(entity: RepositoryEntity) {
        if (itemView is RepositoryWidgetView) {
            itemView.content = entity
        }
    }

}