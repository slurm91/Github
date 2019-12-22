package home.vzhilko.domain.feature.auth.entity

data class AuthParamsEntity(
    val clientId: String,
    val clientSecret: String,
    val code: String,
    val redirectUri: String
)