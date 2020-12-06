package nl.greaper.kosu

import com.fasterxml.jackson.databind.ObjectMapper
import nl.greaper.kosu.model.oauth.Authorization
import nl.greaper.kosu.model.Config
import nl.greaper.kosu.model.Response
import nl.greaper.kosu.model.osu.Me

class OsuClient(private val config: Config) {
    companion object {
        const val API_ENDPOINT = "https://osu.ppy.sh/api/v2"
        const val OAUTH_ENDPOINT = "https://osu.ppy.sh/oauth"
    }

    private val objectMapper = ObjectMapper()
    private val httpClient: HttpClient

    init {
        httpClient = HttpClient(objectMapper)
    }

    fun requestOAuthToken(code: String): Response<Authorization> {
        val params = mapOf(
            "client_id" to config.client_id,
            "client_secret" to config.client_secret,
            "code" to code,
            "grand_type" to "authorization_code",
            "redirect_uri" to config.redirect_uri
        )

        return httpClient.post("$OAUTH_ENDPOINT/token", params)
    }

    fun getMe(bearerToken: String): Response<Me> {
        return httpClient.get("$API_ENDPOINT/me", bearerToken)
    }
}