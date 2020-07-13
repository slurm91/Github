package home.vzhilko.main.domain.repository

import home.vzhilko.main.domain.entity.RepositoryEntity
import io.reactivex.Single

interface IMainRepository {

    fun getRepositoriesList(): Single<List<RepositoryEntity>>

}