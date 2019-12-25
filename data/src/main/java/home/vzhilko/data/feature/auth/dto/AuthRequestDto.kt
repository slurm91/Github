package home.vzhilko.data.feature.auth.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AuthRequestDto(
    @Expose
    @SerializedName("client_id")
    val clientId: String,

    @Expose
    @SerializedName("client_secret")
    val clientSecret: String,

    @Expose
    @SerializedName("code")
    val code: String,

    @Expose
    @SerializedName("redirect_uri")
    val redirectUri: String
)