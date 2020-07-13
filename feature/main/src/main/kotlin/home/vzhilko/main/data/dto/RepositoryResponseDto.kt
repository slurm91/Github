package home.vzhilko.main.data.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RepositoryResponseDto(
    @Expose
    @SerializedName("name")
    val name: String?,

    @Expose
    @SerializedName("description")
    val description: String?
)