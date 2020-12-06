package nl.greaper.kosu.model

import java.net.URL

data class Response<T>(
    val value: T,
    val code: Int,
    val url: URL
)