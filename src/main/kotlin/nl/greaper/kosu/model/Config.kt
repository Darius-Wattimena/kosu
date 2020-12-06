package nl.greaper.kosu.model

data class Config(
    val client_id: Int,
    val client_secret: String,
    val redirect_uri: String
)