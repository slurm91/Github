package home.vzhilko.auth.domain.entity

data class AuthEntity(
    val accessToken: String,
    val scope: String,
    val tokenType: String
)
