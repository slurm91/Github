package home.vzhilko.main.data.api

import home.vzhilko.main.data.dto.RepositoryResponseDto
import io.reactivex.Single
import retrofit2.http.GET

interface MainApiService {

    @GET("user/repos")
    fun getRepositoriesList(): Single<List<RepositoryResponseDto>?>

}