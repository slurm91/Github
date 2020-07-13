package home.vzhilko.main.data.repository

import home.vzhilko.main.data.api.MainApiService
import home.vzhilko.main.data.mapper.mapToRepositoriesListEntity
import home.vzhilko.main.domain.entity.RepositoryEntity
import home.vzhilko.main.domain.repository.IMainRepository
import io.reactivex.Single

class MainRepository constructor(private val apiService: MainApiService) : IMainRepository {

    override fun getRepositoriesList(): Single<List<RepositoryEntity>> {
        return apiService.getRepositoriesList().map { mapToRepositoriesListEntity(it) }
    }

}