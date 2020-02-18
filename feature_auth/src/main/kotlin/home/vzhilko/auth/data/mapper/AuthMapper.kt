package home.vzhilko.auth.data.mapper

import home.vzhilko.auth.data.dto.AuthRequestDto
import home.vzhilko.auth.data.dto.AuthResponseDto
import home.vzhilko.auth.domain.entity.AuthEntity
import home.vzhilko.auth.domain.entity.AuthParamsEntity

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