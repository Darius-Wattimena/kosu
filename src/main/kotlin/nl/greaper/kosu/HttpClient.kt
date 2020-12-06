package nl.greaper.kosu

import com.fasterxml.jackson.databind.ObjectMapper
import nl.greaper.kosu.model.Response
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class HttpClient(val objectMapper: ObjectMapper) {
    fun Map<String, Any>.toRequestParams(): String {
        return this.map { (key, value) ->
            "${URLEncoder.encode(key, "UTF-8")}=${URLEncoder.encode(value.toString(), "UTF-8")}"
        }.joinToString(separator = "&")
    }

    inline fun <reified T> post(
        endpoint: String,
        params: Map<String, Any> = emptyMap()
    ): Response<T> {
        val url = URL(endpoint)

        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "POST"

            val wr = OutputStreamWriter(outputStream)
            wr.write(params.toRequestParams())
            wr.flush()

            val result = objectMapper.readValue(inputStream, T::class.java)

            return Response(result, responseCode, url)
        }
    }

    inline fun <reified T> get(
        endpoint: String,
        bearerToken: String,
        params: Map<String, Any> = emptyMap()
    ): Response<T> {
        val url = URL(endpoint + params.toString())

        with(url.openConnection() as HttpURLConnection) {
            this.setRequestProperty("Authorization", "Bearer $bearerToken");

            requestMethod = "GET"

            val result = objectMapper.readValue(inputStream, T::class.java)

            return Response(result, responseCode, url)
        }
    }
}