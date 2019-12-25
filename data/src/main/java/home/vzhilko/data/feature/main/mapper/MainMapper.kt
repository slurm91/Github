package home.vzhilko.data.feature.main.mapper

import home.vzhilko.data.feature.main.dto.RepositoryResponseDto
import home.vzhilko.domain.feature.main.entity.RepositoryEntity

fun mapToRepositoriesListEntity(response: List<RepositoryResponseDto>?): List<RepositoryEntity> {
    return response?.map { RepositoryEntity(it.name, it.description) } ?: listOf()
}