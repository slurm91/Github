package home.vzhilko.data.feature.auth.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AuthResponseDto(
    @Expose
    @SerializedName("access_token")
    val accessToken: String,

    @Expose
    @SerializedName("scope")
    val scope: String,

    @Expose
    @SerializedName("token_type")
    val tokenType: String
)