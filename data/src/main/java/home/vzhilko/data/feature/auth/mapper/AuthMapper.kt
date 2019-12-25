package home.vzhilko.data.feature.auth.mapper

import home.vzhilko.data.feature.auth.dto.AuthRequestDto
import home.vzhilko.data.feature.auth.dto.AuthResponseDto
import home.vzhilko.domain.feature.auth.entity.AuthEntity
import home.vzhilko.domain.feature.auth.entity.AuthParamsEntity

fun mapFromAuthParamsEntity(entity: AuthParamsEntity): AuthRequestDto {
    return with(entity) {
        AuthRequestDto(clientId, clientSecret, code, redirectUri)
    }
}

fun mapToAuthEntity(response: AuthResponseDto): AuthEntity {
    return with(response) {
        AuthEntity(accessToken, scope, tokenType)
    }
}