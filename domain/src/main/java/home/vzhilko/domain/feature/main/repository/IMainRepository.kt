package home.vzhilko.domain.feature.main.repository

import home.vzhilko.domain.feature.main.entity.RepositoryEntity
import io.reactivex.Single

interface IMainRepository {

    fun getRepositoriesList(): Single<List<RepositoryEntity>>

}