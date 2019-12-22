package home.vzhilko.domain.feature.auth.entity

data class AuthEntity(
    val accessToken: String,
    val scope: String,
    val tokenType: String
)
