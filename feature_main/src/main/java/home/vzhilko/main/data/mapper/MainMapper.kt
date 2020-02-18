package home.vzhilko.main.data.mapper

import home.vzhilko.main.data.dto.RepositoryResponseDto
import home.vzhilko.main.domain.entity.RepositoryEntity

fun mapToRepositoriesListEntity(response: List<RepositoryResponseDto>?): List<RepositoryEntity> {
    return response?.map { RepositoryEntity(it.name, it.description) } ?: listOf()
}