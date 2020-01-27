package home.vzhilko.data.feature.main.repository

import home.vzhilko.data.feature.main.api.MainApiService
import home.vzhilko.data.feature.main.mapper.mapToRepositoriesListEntity
import home.vzhilko.domain.feature.main.entity.RepositoryEntity
import home.vzhilko.domain.feature.main.repository.IMainRepository
import io.reactivex.Single

class MainRepository constructor(private val apiService: MainApiService) : IMainRepository {

    override fun getRepositoriesList(): Single<List<RepositoryEntity>> {
        return apiService.getRepositoriesList().map { mapToRepositoriesListEntity(it) }
    }

}