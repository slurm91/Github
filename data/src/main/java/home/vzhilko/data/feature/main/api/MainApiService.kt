package home.vzhilko.data.feature.main.api

import home.vzhilko.data.feature.main.dto.RepositoryResponseDto
import io.reactivex.Single
import retrofit2.http.GET

interface MainApiService {

    @GET("user/repos")
    fun getRepositoriesList(): Single<List<RepositoryResponseDto>?>

}