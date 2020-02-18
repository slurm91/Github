package home.vzhilko.main.presentation.view.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import home.vzhilko.main.domain.entity.RepositoryEntity
import home.vzhilko.main.presentation.view.component.RepositoryWidgetView

class RepositoriesListAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun populate(entity: RepositoryEntity) {
        if (itemView is RepositoryWidgetView) {
            itemView.content = entity
        }
    }

}