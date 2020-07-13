package home.vzhilko.auth.domain.entity

data class AuthParamsEntity(
    val clientId: String,
    val clientSecret: String,
    val code: String,
    val redirectUri: String
)